package com.ohnong.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ohnong.app.main.service.MemberService;

@RestController
public class memberControllor {
	@Autowired
	MemberService memberService;
	

}
