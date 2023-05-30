package com.ohnong.app.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.community.mapper.ReplyMapper;
import com.ohnong.app.community.service.Criteria_1;
import com.ohnong.app.community.service.ReplyService;
import com.ohnong.app.community.service.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	ReplyMapper replyMapper;
	
	@Override
	public List<ReplyVO> getReplyList(Criteria_1 criteria,int boardBno) {
		// TODO Auto-generated method stub
		return replyMapper.getReplyList(criteria, boardBno);
	}

	@Override
	public int replyCount(int boardBno) {
		// TODO Auto-generated method stub
		return replyMapper.replyCount(boardBno);
	}

	@Override
	public int insertReply(int boardBno, String replyboardContent ,String userId) {
		// TODO Auto-generated method stub
		return replyMapper.insertReply(boardBno, replyboardContent ,userId);
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.replyUpdate(vo);
	}

	@Override
	public ReplyVO getReply(int replyboardBno) {
		// TODO Auto-generated method stub
		return replyMapper.getReply(replyboardBno);
	}

	//댓글삭제
	@Override
	public int deleteReply(int replyboardBno) {
		// TODO Auto-generated method stub
		return replyMapper.deleteReply(replyboardBno);
	}

	@Override   
	public List<ReplyVO> getMyReply(Criteria_1 criteria,String userId) {
		// TODO Auto-generated method stub
		return replyMapper.getMyReply(criteria, userId);
	}

	@Override
	public int myReplyTotal(Criteria_1 criteria, String userId) {
		// TODO Auto-generated method stub
		return replyMapper.myReplyTotal(criteria,userId);
	}

	@Override
	public int insertAdminReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		replyMapper.adminRep(vo.getBoardBno()); //보드 업데이트
		return replyMapper.insertAdminReply(vo);
	}

	@Override
	public List<ReplyVO> getAdminReply(int boardBno) {
		// TODO Auto-generated method stub
		return replyMapper.getAdminReply(boardBno);
	}







}
