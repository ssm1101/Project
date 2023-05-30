package com.ohnong.app.community.service;

import java.util.List;

public interface ReplyService {

	public List<ReplyVO> getReplyList(Criteria_1 criteria,int boardBno);//글의 댓글 가져오기.
	
	public int replyCount(int boardBno); //글의 댓글 갯수 가져오기

	public int insertReply(int boardBno, String replyboardContent , String userId);  //댓글작성
	
	public int replyUpdate(ReplyVO vo); //댓글수정
	
	public ReplyVO getReply(int replyboardBno); //댓글 한건 조회
	
	public int deleteReply(int replyboardBno); //댓글 삭제   
	
	public List<ReplyVO> getMyReply(Criteria_1 criteria,String userId); //내 댓글목록
	
	public int myReplyTotal(Criteria_1 criteria,String userId);//내 댓글 갯수
	
	public List<ReplyVO> getAdminReply(int boardBno); //관리자 댓글 가져오기
	
	public int insertAdminReply(ReplyVO vo);// 관리자의 댓글등록
	
	
}
