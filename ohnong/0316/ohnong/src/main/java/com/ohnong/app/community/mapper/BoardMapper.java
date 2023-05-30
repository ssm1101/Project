package com.ohnong.app.community.mapper;

import java.util.List;

import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;

public interface BoardMapper {
	
	public List<BoardVO> getAllBoardList(Criteria_1 criteria);	//커뮤니티게시판 글 전체목록 조회;

	public BoardVO getBoard(int boardBno);//일단 get방식 상세조회페이지

	public int getTotal(Criteria_1 criteria);//페이징을 위한 커뮤니티 글 전체갯수가져오기

	public int insertCommu(BoardVO vo); //커뮤니티글작성

	public int updateCommu(BoardVO vo);//커뮤니티 수정
	
	public int addHitCount(int boardBno);//조회수 증가
	
	public int deleteBoard(int boardBno); //글 삭제
	
	public List<BoardVO> proAnswerList(Criteria_1 criteria); //전문인에게 묻는다 카테고리의 리스트.
	
	public int getProTotal(Criteria_1 criteria);
	
	public List<BoardVO> getMyBoardList(Criteria_1 criteria,String userId);//내가 쓴 글 목록
	
	public int getMyTotal(Criteria_1 criteria,String userId);//내가 쓴 글 total
		
}
