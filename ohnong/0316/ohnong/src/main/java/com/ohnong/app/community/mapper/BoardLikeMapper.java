package com.ohnong.app.community.mapper;

import java.util.List;

import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;

public interface BoardLikeMapper {

	//글의 추천갯수 1추가
	public void updateLike(int boardBno);
	
	//글의 추천갯수 1감소
	public void updateLikeCancle(int boardBno);

	//boardLike에 정보넣기
	public void insertLike(int boardBno,String userId);
	
	//boardLike에서 삭제
	public void deleteLike(int boardBno,String userId);
	
	//boardLike에 있는지 확인.
	public int likeCheck(int boardBno, String userId);
	
	public List<BoardVO> getLikeBoard(Criteria_1 criteria,String userId);//내가 추천한 목록
	
	public int getLikeTotal(Criteria_1 criteria,String userId);//내가 추천한 글 total
	
}
