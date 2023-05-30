package com.ohnong.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ohnong.app.main.service.MemberService;
import com.ohnong.app.main.service.MemberVO;

@Controller
public class TestControllor {

	@Autowired
	MemberService memberSerivce;
	
	@GetMapping("/main")
	public String main() {
		return "content/main/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "content/main/login";
	}
	
	@GetMapping("/findId")
	public String findId() {
		return "content/main/findId";
	}
	
	@GetMapping("/findPw")
	public String findPw() {
		return "content/main/findPw";
	}
	
	@GetMapping("/modPw")
	public String modPw() {
		return "content/main/modPw";
	}
	
	@GetMapping("/join")
	public String join() {
		return "content/main/join";
	}
	
	@PostMapping("/join")
	public String joinPeocess(MemberVO memberVO) {
		memberSerivce.insertMemberInfo(memberVO);
		return "redirect:main";
	}
	

	
}
