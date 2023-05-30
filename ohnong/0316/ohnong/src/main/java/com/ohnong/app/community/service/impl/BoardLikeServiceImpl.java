package com.ohnong.app.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohnong.app.community.mapper.BoardLikeMapper;
import com.ohnong.app.community.service.BoardLikeService;
import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;

@Service
public class BoardLikeServiceImpl implements BoardLikeService{
	
	@Autowired
	BoardLikeMapper boardLikeMapper;

	@Override
	@Transactional
	public int updateLike(int boardBno,String userId) {
		
		//likecheck 에 있는지 확인
		int likeCheck = boardLikeMapper.likeCheck(boardBno, userId);
			
		if(likeCheck == 0) {
			//추천 한적 없는 경우
			boardLikeMapper.insertLike(boardBno, userId);
			boardLikeMapper.updateLike(boardBno);	
			
		}else if(likeCheck ==1){
			
			//있으면 삭제.
			boardLikeMapper.deleteLike(boardBno, userId);
			boardLikeMapper.updateLikeCancle(boardBno);
		}
		return likeCheck;			
	}
	
	@Override
	public int likeCheck(int boardBno, String userId) {
		// TODO Auto-generated method stub
		return boardLikeMapper.likeCheck(boardBno, userId);
	}

	@Override
	public List<BoardVO> getLikeBoard(Criteria_1 criteria, String userId) {
		// TODO Auto-generated method stub
		return boardLikeMapper.getLikeBoard(criteria, userId);
	}

	@Override
	public int getLikeTotal(Criteria_1 criteria, String userId) {
		// TODO Auto-generated method stub
		return boardLikeMapper.getLikeTotal(criteria, userId);
	}
	
}
