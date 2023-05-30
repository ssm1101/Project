package com.ohnong.app.notice.service;

import java.util.List;

public interface NoticeService {
	
	// 글 등록
	public int noticeRegister(NoticeVO notice);
	
	// 전체 목록 조회
	public List<NoticeVO> getAllList();
	
	// 게시판 목록 페이징 적용
	public List<NoticeVO> getListPaging(Criteria_2 cri);
	
	// 게시판 목록 총 개수
	public int getTotal(Criteria_2 cri);
	
	// 단건 조회
	public NoticeVO getNotice(int noticeNo);
	
	// 글 수정
	public int modify(NoticeVO notice);
	
	// 글 삭제
	public int delete(NoticeVO notice);
	
	
	
	

}
