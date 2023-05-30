package com.ohnong.app.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ohnong.app.main.service.MemberService;
import com.ohnong.app.main.service.MemberVO;

@Controller
public class TestControllor {

	@Autowired
	MemberService memberService;

	// 메인
	@GetMapping("/main")
	public String main() {
		return "content/main/main";
	}

	// 로그인
	@GetMapping("/login")
	public String login() {
		return "content/main/login";
	}

	// 회원가입
	@GetMapping("/join")
	public String join() {
		return "content/main/join";
	}

	@PostMapping("/join")
	public String joinProcess(MemberVO memberVO) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String rawPw = ""; // 사용자가 입력한 비밀번호
		String encodePw = ""; // 암호화하여 저장

		rawPw = memberVO.getPassword();
		encodePw = bcrypt.encode(rawPw);
		memberVO.setUserPw(encodePw);

		// 회원가입 서비스 실행
		memberService.insertMemberInfo(memberVO);
		return "redirect:/main";
	}

	// 회원가입 - 아이디 중복 체크
	@GetMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam("userId") String userId) { // 받을 데이터 타입이 String
		System.out.println("param : " + userId);

		int checkNum = memberService.checkId(userId);

		if (checkNum == 1) {
			System.out.println("아이디 중복");
			return "duplicated";
		} else {
			System.out.println("아이디 사용 가능");
			return "available";
		}
	}

	// 아이디 찾기
	@GetMapping("/findId")
	public String findId() {
		return "content/main/findId";
	}

	@PostMapping("/findId")
	@ResponseBody
	public String findId(@RequestParam(required = false) String userName,
			@RequestParam(required = false) String birth) {
		System.out.println("param : " + userName);
		System.out.println("param : " + birth);

		String checkId = memberService.findId(userName, birth);
		System.out.println("checkId : " + checkId);

		if (checkId != null) {
			System.out.println("아이디 존재");
			return checkId;
		} else {
			System.out.println("아이디 미존재");
			return "false";
		}
	}

	// 비밀번호 찾기
	@GetMapping("/findPw")
	public String findPw() {
		return "content/main/findPw";
	}

	@GetMapping("/checkPw")
	@ResponseBody
	public int checkPw(MemberVO memberVO, Model model) {
		int x = 0;
		if (memberService.checkPw(memberVO) == null) {
			x = 1;
		} else {
			x = 2;
			memberService.changePw(memberVO);
		}
		return x;
	}

	// 비밀번호 변경
	@GetMapping("/modPw")
	public String modPw() {
		return "content/main/modPw";
	}
	
	@PostMapping("/modPw")
	public String modPwProcess(Model model, MemberVO memberVO, @RequestParam(value = "userPw") String userPw) {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String rawPw = userPw; // 사용자가 입력한 비밀번호
		String encodePw = ""; // 암호화하여 저장

		rawPw = memberVO.getPassword();
		encodePw = bcrypt.encode(rawPw);
		memberVO.setUserPw(encodePw);
		
		// 서비스 실행
		memberService.modPw(memberVO);
		
		return "redirect:/memberInfo";
	}

	// ##### member #####
	// 회원 본인 정보 조회
	@GetMapping("/memberInfo")
	public String memberInfo(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");

		model.addAttribute("memberList", memberService.getMemberInfo(userId));
		return "content/member/memberInfo";
	}

	// 사이드바
	@GetMapping("/sidebarMagement")
	public String memberInfo3(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");

		model.addAttribute("memberList3", memberService.getMemberInfo(userId));
		return "fragment/sidebarMagement";
	}

	// 회원 본인 정보 수정
	@GetMapping("/memberMod")
	public String memberMod(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		model.addAttribute("memberList", memberService.getMemberInfo(userId));
		return "content/member/memberMod";
	}

	@PostMapping("/memberMod")
	public String memberMod(Model model, MemberVO memberVO, RedirectAttributes rttr,
			@RequestParam(value = "profileImg1") MultipartFile profileImg1) throws IOException {

			String uploadDir = "/etc/";
			
			if (profileImg1 == null || profileImg1.isEmpty()) {
				System.out.println("널널");
				memberService.memberMod2(memberVO);
				System.out.println("변경 성공");
				rttr.addFlashAttribute("result", "success");
				
		    } else {
		    	String fileName = profileImg1.getOriginalFilename();
				Path path = Paths.get(uploadDir + fileName);
				Files.write(path, profileImg1.getBytes());
				String filePath = uploadDir + fileName;
				memberVO.setFilePath(filePath);
				
				if (memberService.memberMod(memberVO)) {
					System.out.println("변경 성공");
					rttr.addFlashAttribute("result", "success");
				} else {
					System.out.println("변경 실패");
					rttr.addFlashAttribute("result", "fail");
				}

		    }

			return "redirect:/memberInfo";
	}

	// 관리자 회원 조회
	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("memberList", memberService.memberList());
		return "content/member/memberList";
	}

	// 관리자 회원 삭제(업데이트)
	@GetMapping("/memberDelete/{userId}")
	@ResponseBody
	public String memberDelete(@PathVariable("userId") String userId) {
		int result = memberService.memberDelete(userId);
		String message = "";
		if (result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

	//////////////////////////////////////////////////

}
