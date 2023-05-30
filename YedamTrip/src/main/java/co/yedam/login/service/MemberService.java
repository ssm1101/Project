package co.yedam.login.service;

import java.util.List;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.notice.vo.NoticeVO;

public interface MemberService {
	//로그인
	public MemberVO loginCheck(MemberVO vo);
	//일반회원가입
	public int userInsert(MemberVO vo);
	//판매자회원가입
	public int sellerInsert(MemberVO vo);
	//아이디중복검사(일반)
	public MemberVO checkId(MemberVO vo);
	//아이디중복검사(판매자)
	public MemberVO sellerCkeckId(MemberVO vo);
	//비밀번호 찾기
	public MemberVO findPass(MemberVO vo);
	//일반회원조회
	public List<MemberVO> userList(int pageNum);
	//일반회원??
	public int userListPagingTotalCnt();
	//일반회원삭제
	public int userDelete(String mbId);
	//일반회원조회
	public List<MemberVO> sellerList(int pageNum);
	//일반회원??
	public int sellerListPagingTotalCnt();
	//일반회원삭제
	public int sellerDelete(String mbId);
	
	public MemberVO memberSearch(String id);
	
	public int sellerPermiss(String mbId);
	
	public int modMyPage(MemberVO vo);
	
	public MemberVO myPageView(MemberVO vo);

	public int updateMember(MemberVO vo);
}
