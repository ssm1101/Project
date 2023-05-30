package com.ohnong.app.notice.mapper;

import java.util.List; 

import com.ohnong.app.notice.service.Criteria_2;
import com.ohnong.app.notice.service.NoticeVO;

public interface NoticeMapper {
	
	//글등록
	public int insert(NoticeVO notice); // 입력 후 생선된 글번호 확인
	
	//전체조회
	public List<NoticeVO> selectAllNoticeList();
	
	// 게시판 목록( 페이지 적용 )
	public List<NoticeVO>getListPaging(Criteria_2 cri);

	//단건조회
	public NoticeVO getNotice(int noticeNo);
	
	// 내용 수정
	public int modify(NoticeVO notice);

	// 글 삭제
	public int delete(NoticeVO notice);
	
	// 게시판 목록 총 개수
	public int getTotal(Criteria_2 cri);
	
	//	조회수
	public int addHitCount(int noticeId);

	
	
	

}
