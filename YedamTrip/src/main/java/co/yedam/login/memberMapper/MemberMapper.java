package co.yedam.login.memberMapper;

import java.util.List;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.notice.vo.NoticeVO;

public interface MemberMapper {
	//로그인
	public MemberVO loginCheck(MemberVO vo);
	//일반회원가입
	public int userInsert(MemberVO vo);
	//판매자회원가입
	public int sellerInsert(MemberVO vo);
	//아이디중복확인(일반사용자)
	public MemberVO checkId(MemberVO vo);
	//아이디중복확인(판매자)
	public MemberVO sellerCkeckId(MemberVO vo);
	//비밀번호찾기
	public MemberVO findPass(MemberVO vo);
	//회원조회
	public MemberVO memberSearch(String id);
	//일반회원리스트
	public List<MemberVO> userList(int pageNum);
	//일반회원페이징
	public int userListPagingTotalCnt();
	//일반회원삭제
	public int userDelete(String mbId);
	//판매자회원리스트
	public List<MemberVO> sellerList(int pageNum);
	//판매자페이징
	public int sellerListPagingTotalCnt();
	//판매자삭제
	public int sellerDelete(String mbId);
	public Object memberSearch(MemberVO vo);
	public int sellerPermiss(String mbId);
	public int modMyPage(MemberVO vo);
	public MemberVO myPageView(MemberVO vo);
	public int updateMember(MemberVO vo);
}
