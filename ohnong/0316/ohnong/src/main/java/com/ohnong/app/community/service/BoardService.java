package com.ohnong.app.community.service;

import java.util.List;

public interface BoardService {

	//글리스트
	public List<BoardVO> getAllBoardList(Criteria_1 cri);

	//상세조회
	public BoardVO getBoard(int boardBno);
	
	//전체글수조회
	public int getTotal(Criteria_1 criteria);

	//글작성
	public int insertCommu(BoardVO vo);
	
	//글수정
	public int modifyCommu(BoardVO vo);
	
	public int deleteBoard(int boaordBno);
	
	//전문인 카테고리 글 리스트
	public List<BoardVO> proAnswerList(Criteria_1 criteria);
	
	public int getProTotal(Criteria_1 criteria);
	
	public List<BoardVO> getMyBoardList(Criteria_1 criteria,String userId);//내가 쓴 글 목록	
	
	public int getMyTotal(Criteria_1 criteria,String userId);//내가 쓴 글 total
}
