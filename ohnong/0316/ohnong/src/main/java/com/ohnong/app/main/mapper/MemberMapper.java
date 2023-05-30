package com.ohnong.app.main.mapper;

import java.util.List;

import com.ohnong.app.main.service.MemberVO;

public interface MemberMapper {

	// 로그인
	public MemberVO login(MemberVO memberVO);
	
	// 회원가입
	public int insertMemberInfo(MemberVO memberVO);

	// 아이디 중복 체크
	public int checkId(String account);

	// 아이디 찾기
	public String findId(String userName, String birth);

	// 비밀번호 찾기1
	public MemberVO checkPw(MemberVO memberVO);

	// 비밀번호 찾기2
	public int changePw(MemberVO memberVO);

	// 회원 본인 정보 조회
	public MemberVO selectMemberInfo(String userId);
	
	// 회원 본인 정보 수정
	public int memberUpdate(MemberVO memberVO);

	// 관리자용 회원 조회
	public List<MemberVO> memberList();

	// 관리자용 회원 삭제(업데이트)
	public int memberDelete(String userId);

	// 비밀번호 찾기 -> 디비 업데이트
	public int updatePw(MemberVO vo);
	
	// 비밀번호 변경
	public int modPw(MemberVO memberVO);

	// 회원 본인 정보 수정2
	public int memberUpdate2(MemberVO memberVO);

}
