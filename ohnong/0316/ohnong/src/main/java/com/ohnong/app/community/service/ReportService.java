package com.ohnong.app.community.service;

import java.util.List;

public interface ReportService {

	public int reportWrite(ReportVO vo);
	
	public List<BoardVO> reportBoardList(Criteria_1 criteria);//3회이상 신고받은 글 리스트
	
	public int reportBoardTotal(Criteria_1 criteria);//신고받은 글 리스트 total
	
	public List<ReportVO> reportList(int boardBno); //신고글 리스트
	
	public int boardBlind(int boardBno);//신고글 블라인드
	
	public int boardRestore(int boardBno);//블라인드 글 복구
}
