package co.yedam.notice.service;

import java.util.List;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.notice.vo.NoticeVO;


public interface NoticeService {
	//공지사항 목록
	public List<NoticeVO> noticeList(int pageNum);
	//공지사항 개시글수
	public int noticeListPagingTotalCnt();
	//공지사항 등록
	public int noticeAdd(NoticeVO vo);
	//공지사항 조회
	public NoticeVO noticeSearch(int psId);
	//공지사항 수정
	public int noticeUpdate(NoticeVO vo);
	//공지사항 삭제
	public int noticeDelete(int psId);
	//QnA Q등록
	public int qAdd(NoticeVO vo);
	//QnA 목록(user)
	public List<NoticeVO> qnaList(int pageNum, MemberVO vo);
	//QnA 목록수
	public int qnaListPagingTotalCnt(String mbId);
	//QnA Q수정
	public int qUpdate(NoticeVO vo);
	//QnA admin 목록수
	public int DashbordQnaListPagingTotalCnt();
	//QnA admin 목록
	public List<NoticeVO> DashbordQnaList(int pageNum);
	//공지사항 메인
	public List<NoticeVO> noticeMain();
	//QnA seller 목록수
	public int SellerQnaListTotalCnt(String mbId);
	//QnA seller 목록
	public List<NoticeVO> SellerQnaList(int pageNum, MemberVO vo);
	//QnA 판매자 문의 등록
	public int qAddProduct(NoticeVO vo);
}
