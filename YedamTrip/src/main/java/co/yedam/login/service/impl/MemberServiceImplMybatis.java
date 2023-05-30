package co.yedam.login.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.login.memberMapper.MemberMapper;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;


public class MemberServiceImplMybatis implements MemberService {

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return  mapper.loginCheck(vo);
	}
	@Override
	public int userInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.userInsert(vo);
	}
	@Override
	public int sellerInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.sellerInsert(vo);
	}
	@Override
	public MemberVO checkId(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.checkId(vo);
	}
	@Override
	public MemberVO findPass(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.findPass(vo);
	}
	@Override
	public List<MemberVO> userList(int pageNum) {
		// TODO Auto-generated method stub
		return mapper.userList(pageNum);
	}
	@Override
	public int userListPagingTotalCnt() {
		// TODO Auto-generated method stub
		return mapper.userListPagingTotalCnt();
	}
	@Override
	public int userDelete(String mbId) {
		// TODO Auto-generated method stub
		return mapper.userDelete(mbId);
	}
	@Override
	public List<MemberVO> sellerList(int pageNum) {
		// TODO Auto-generated method stub
		return mapper.sellerList(pageNum);
	}
	@Override
	public int sellerListPagingTotalCnt() {
		// TODO Auto-generated method stub
		return mapper.sellerListPagingTotalCnt();
	}
	@Override
	public int sellerDelete(String mbId) {
		// TODO Auto-generated method stub
		return mapper.sellerDelete(mbId);
	}
	@Override
	public MemberVO sellerCkeckId(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.sellerCkeckId(vo);
	}

	@Override
	public MemberVO memberSearch(String id) {
		return mapper.memberSearch(id);
	}
	@Override
	public int sellerPermiss(String mbId) {
		// TODO Auto-generated method stub
		return mapper.sellerPermiss(mbId);
	}
	@Override
	public int modMyPage(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.modMyPage(vo);
	}
	@Override
	public MemberVO myPageView(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.myPageView(vo);
	}	
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateMember(vo);
	}
}
