package com.ohnong.app.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.community.mapper.BoardMapper;
import com.ohnong.app.community.service.BoardService;
import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardmapper;
	
	@Override
	public List<BoardVO> getAllBoardList(Criteria_1 cri) {
		// TODO Auto-generated method stub
		return boardmapper.getAllBoardList(cri);
		
	}

	@Override
	public BoardVO getBoard(int boardBno) {
		// TODO Auto-generated method stub
		boardmapper.addHitCount(boardBno);		
		return boardmapper.getBoard(boardBno);
	}

	@Override
	public int getTotal(Criteria_1 criteria) {
		// TODO Auto-generated method stub
		return boardmapper.getTotal(criteria);
	}

	@Override
	public int insertCommu(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardmapper.insertCommu(vo);
	}

	@Override
	public int modifyCommu(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardmapper.updateCommu(vo);
	}

	@Override
	public int deleteBoard(int boaordBno) {
		// TODO Auto-generated method stub
		return boardmapper.deleteBoard(boaordBno);
	}

	@Override
	public List<BoardVO> proAnswerList(Criteria_1 criteria) {
		// TODO Auto-generated method stub
		return boardmapper.proAnswerList(criteria);
	}

	@Override
	public int getProTotal(Criteria_1 criteria) {
		// TODO Auto-generated method stub
		return boardmapper.getProTotal(criteria);
	}

	@Override
	public List<BoardVO> getMyBoardList(Criteria_1 criteria, String userId) {
		// TODO Auto-generated method stub		
		return boardmapper.getMyBoardList(criteria, userId);
	}

	@Override
	public int getMyTotal(Criteria_1 criteria,String userId) {
		// TODO Auto-generated method stub
		return boardmapper.getMyTotal(criteria,userId);
	}
	
	


}
