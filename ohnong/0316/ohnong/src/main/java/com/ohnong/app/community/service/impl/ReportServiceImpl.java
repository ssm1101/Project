package com.ohnong.app.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.community.mapper.ReportMapper;
import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;
import com.ohnong.app.community.service.ReportService;
import com.ohnong.app.community.service.ReportVO;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	ReportMapper reportMapper;
	
	@Override
	public int reportWrite(ReportVO vo) {
		// TODO Auto-generated method stub
		//신고글 등록
		int result= reportMapper.reportWrite(vo);
		reportMapper.reportCount(vo.getBoardBno());		
		return result;
	}

	@Override
	public List<BoardVO> reportBoardList(Criteria_1 criteria) {
		// TODO Auto-generated method stub
		return reportMapper.reportBoardList(criteria);
	}

	@Override
	public int reportBoardTotal(Criteria_1 criteria) {
		// TODO Auto-generated method stub
		return reportMapper.reportBoardTotal(criteria);
	}

	@Override
	public List<ReportVO> reportList(int boardBno) {
		// TODO Auto-generated method stub
		return reportMapper.reportList(boardBno);
	}

	@Override    //신고글 블라인드
	public int boardBlind(int boardBno) {
		// TODO Auto-generated method stub
		return reportMapper.boardBlind(boardBno);
	}

	@Override
	public int boardRestore(int boardBno) {
		// TODO Auto-generated method stub
		return reportMapper.boardRestore(boardBno);
	}
	
	

}
