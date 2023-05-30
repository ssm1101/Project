package com.ohnong.app.community.mapper;

import java.util.List;

import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;
import com.ohnong.app.community.service.ReportVO;

public interface ReportMapper {

	public int reportWrite(ReportVO vo);//신고글 작성
	
	public void reportCount(int boardBno);//글 신고횟수 update
	
	public List<BoardVO> reportBoardList(Criteria_1 criteria);//3회이상 신고받은 글 리스트
	
	public int reportBoardTotal(Criteria_1 criteria);//신고받은 글 리스트 total
	
	public List<ReportVO> reportList(int boardBno); //신고글 리스트
	
	public int boardBlind(int boardBno);//신고글 블라인드
	
	public int boardRestore(int boardBno);//블라인드 글 복구
	
	
}
