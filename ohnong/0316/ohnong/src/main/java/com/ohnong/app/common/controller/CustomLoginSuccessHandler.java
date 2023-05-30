package com.ohnong.app.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ohnong.app.main.service.MemberService;
import com.ohnong.app.main.service.MemberVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private MemberService memberService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		HttpSession session = request.getSession();

		if (session != null) {
			MemberVO memberVO = new MemberVO();
			memberVO.setUserId(authentication.getName());
			MemberVO member = (MemberVO) session.getAttribute("login");

			if (member == null) {
				member = memberService.login(memberVO);

				session.setAttribute("login", member);
				session.setAttribute("memberInfo", member);
				session.setAttribute("userId", member.getUserId());

				if (member.getTemporaryPw().equals("Y")) {
					response.sendRedirect("/ohnong/modPw");
				} else if (member.getTemporaryPw().equals("N")) {
					response.sendRedirect("/ohnong/main");
				}
			}
		}
		


	}
}