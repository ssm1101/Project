package com.ohnong.app.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ohnong.app.notice.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService service;
	

//	지원사업조회
	@GetMapping("/subProject")
	public String subProject() {
		return "content/subProject/subProject";
	}

//	청년농 소개2
	@GetMapping("/youthCase")
	public String youthCase() {
		return "content/subProject/youthCase";
	}
	

//	청년농 소개2
	@GetMapping("/youthCase2")
	public String youthCase2() {
		return "content/subProject/youthCase2";
	}

//	청년농 소개
	@GetMapping("/farmerInfo")
	public String farmerInfo() {
		return "content/subProject/farmerInfo";
	}

// 	기술 우수사례
	@GetMapping("/youthPolicy")
	public String bestTech() {
		return "content/subProject/youthPolicy";
	}
    

//	프로젝트 단건조회 페이지
	@PostMapping("/getProject")
	public String getProject() {
		return "content/subProject/getProject";
	}
	

}
