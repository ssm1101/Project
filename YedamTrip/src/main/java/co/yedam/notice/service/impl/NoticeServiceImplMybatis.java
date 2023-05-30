package co.yedam.notice.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.MemberPageInfo;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.notice.mapper.NoticeMapper;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.vo.NoticeVO;

public class NoticeServiceImplMybatis implements NoticeService {
	SqlSession session = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	@Override
	public List<NoticeVO> noticeList(int pageNum) {
		return mapper.noticeList(pageNum);
	}
	@Override
	public int noticeListPagingTotalCnt() {
		return mapper.noticeListPagingTotalCnt();
	}
	@Override
	public int noticeAdd(NoticeVO vo) {
		return mapper.noticeAdd(vo);
	}
	@Override
	public NoticeVO noticeSearch(int psId) {
		return mapper.noticeSearch(psId);
	}
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return mapper.noticeUpdate(vo);
	}
	@Override
	public int noticeDelete(int psId) {
		return mapper.noticeDelete(psId);
	}
	@Override
	public int qAdd(NoticeVO vo) {
		return mapper.qAdd(vo);
	}
	@Override
	public List<NoticeVO> qnaList(int pageNum, MemberVO vo) {
		MemberPageInfo cri = new MemberPageInfo(pageNum, 3);
		cri.setMbId(vo.getMbId());
		return mapper.qnaList(cri);
	}
	@Override
	public int qUpdate(NoticeVO vo) {
		return mapper.qUpdate(vo);
	}
	@Override
	public int qnaListPagingTotalCnt(String mbId) {
		return mapper.qnaListPagingTotalCnt(mbId);
	}
	@Override
	public int DashbordQnaListPagingTotalCnt() {
		return mapper.DashbordQnaListPagingTotalCnt();
	}
	@Override
	public List<NoticeVO> DashbordQnaList(int pageNum) {
		return mapper.DashbordQnaList(pageNum);
	}
	@Override
	public List<NoticeVO> noticeMain() {
		return mapper.noticeMain();
	}
	@Override
	public int SellerQnaListTotalCnt(String mbId) {
		return mapper.SellerQnaListTotalCnt(mbId);
	}
	@Override
	public List<NoticeVO> SellerQnaList(int pageNum, MemberVO vo) {
		MemberPageInfo cri = new MemberPageInfo(pageNum, 10);
		cri.setMbId(vo.getMbId());
		return mapper.SellerQnaList(cri);
	}
	@Override
	public int qAddProduct(NoticeVO vo) {
		return mapper.qAddProduct(vo);
	}
	
}
