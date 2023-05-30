package com.ohnong.app.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.main.mapper.MemberMapper;
import com.ohnong.app.main.service.MemberService;
import com.ohnong.app.main.service.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public int insertMemberInfo(MemberVO memberVO) {
		int result = memberMapper.insertMemberInfo(memberVO);
		return result;
	}

	
}
