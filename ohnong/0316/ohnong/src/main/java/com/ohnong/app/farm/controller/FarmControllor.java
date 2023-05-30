package com.ohnong.app.farm.controller;

import java.io.File; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohnong.app.farm.service.AttachFileDTO;
import com.ohnong.app.farm.service.FarmService;
import com.ohnong.app.farm.service.FarmVO;
import com.ohnong.app.main.service.MemberVO;

@Controller
public class FarmControllor {

	@Autowired
	FarmService farmService;

	// 농가 등록
	@GetMapping("/farmRegister")
	public String farmRegister() {

		return "content/farm/farmRegister";
	}

	@PostMapping("/farmRegister")
	public String farmRegisterProcess(Model model, FarmVO farmVO, RedirectAttributes rttr, 
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) throws IOException {

		String uploadDir = "/etc/"; // D:/test/

		String fileName = uploadFile.getOriginalFilename();
		Path path = Paths.get(uploadDir + fileName);
		Files.write(path, uploadFile.getBytes());
		String filePath = uploadDir + fileName;
		farmVO.setFilePath(filePath);

		farmService.insertFarmInfo(farmVO);
		rttr.addFlashAttribute("result", farmVO.getFarmName());
		return "redirect:/memberInfo";
	}

	// 본인 농가 조회
	@GetMapping("/farmInfo")
	public String farmInfo(@RequestParam("userId") String userId, Model model) {
		model.addAttribute("farmInfo", farmService.getFarmInfo(userId));
		return "content/farm/farmInfo";
	}

	// 본인 농가 수정
	@GetMapping("/farmMod")
	public String farmMod(@RequestParam("userId") String userId, Model model) {
		model.addAttribute("farmInfo", farmService.getFarmInfo(userId));
		return "content/farm/farmMod";
	}

	@PostMapping("/farmMod")
	public String farmMod(FarmVO farmVO, RedirectAttributes rttr) {
		if (farmService.farmMod(farmVO)) {
			System.out.println("변경 성공");
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("변경 실패");
			rttr.addFlashAttribute("result", "fail");
		}

		return "redirect:/farmInfo?userId=" + farmVO.getUserId();
	}

	// 관리자용 농가 조회
	@GetMapping("/farmList")
	public String famrList(Model model) {
		model.addAttribute("farmList", farmService.farmList());
		return "content/farm/farmList";
	}

	// 관리자용 농가 승인
	@GetMapping("/signFarmState")
	@ResponseBody
	public String signFarmState(FarmVO farmVO) {

		System.out.println(farmVO);
		farmService.signFarmState(farmVO);

		return "성공";
	}

	// 관리자용 농가 삭제 + 회원용 농가 탈퇴
	@GetMapping("/farmDelete/{userId}")
	@ResponseBody
	public String farmDelete(@PathVariable("userId") String userId) {
		int result = farmService.farmDelete(userId);
		String message = "";

		// 결과값...
		System.out.println(result);
		if (result == -1) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}
	
	// 농가 중복 체크
	@GetMapping("/checkFarm")
	@ResponseBody
	public String checkId(@RequestParam("farmName") String farmName) { // 받을 데이터 타입이 String

		int checkNum = farmService.checkFarm(farmName);

		if (checkNum == 1) {
			System.out.println("농가 중복");
			return "duplicated";
		} else {
			System.out.println("사용 가능");
			return "available";
		}
	}
}