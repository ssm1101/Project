package com.ohnong.app.community.service;

import java.util.List;

public interface BoardLikeService {
	
	//글의 추천갯수 1추가
	public int updateLike(int boardBno,String userId);
	
	public int likeCheck(int boardBno, String userId);
	
	public List<BoardVO> getLikeBoard(Criteria_1 criteria,String userId);//내가 추천한 목록
	
	public int getLikeTotal(Criteria_1 criteria,String userId);//내가 추천한 글 total
	
}
