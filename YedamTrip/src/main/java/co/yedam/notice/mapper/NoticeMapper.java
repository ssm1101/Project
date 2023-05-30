package co.yedam.notice.mapper;

import java.util.List;

import co.yedam.common.MemberPageInfo;
import co.yedam.notice.vo.NoticeVO;


public interface NoticeMapper {
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
	//QnA q등록
	public int qAdd(NoticeVO vo);
	//QnA 목록(user)
	public List<NoticeVO> qnaList(MemberPageInfo cri);
	//QnA 목록수
	public int qnaListPagingTotalCnt(String mbId);
	//QnA q수정
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
	public List<NoticeVO> SellerQnaList(MemberPageInfo cri);
	//QnA 판매자 문의 등록
	public int qAddProduct(NoticeVO vo);
}
