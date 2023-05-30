package com.ohnong.app.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.notice.mapper.NoticeMapper;
import com.ohnong.app.notice.service.Criteria_2;
import com.ohnong.app.notice.service.NoticeService;
import com.ohnong.app.notice.service.NoticeVO;

@Service
public class NoticeServiceImpl  implements NoticeService{
	
	@Autowired
	NoticeMapper noticeMapper;
	//빈으로서 등록
	//인터페이스  no 클래스 빈으로등록x 
	//클래스 중 빈으로 등록된걸 찾아
	
	//전체 목록 조회
	public List<NoticeVO> getAllList(){
		return noticeMapper.selectAllNoticeList();
	}

	
	// 단건 조회
	@Override
	public NoticeVO getNotice(int noticeNo) {
		// TODO Auto-generated method stub
		
		noticeMapper.addHitCount(noticeNo);
		return noticeMapper.getNotice(noticeNo);
	}
	
	

	// 게시글 등록
	@Override
	public int noticeRegister(NoticeVO notice) {
		// 등록
		int result = noticeMapper.insert(notice);
		return result;
		
		
	}

	//수정
	@Override
	public int modify(NoticeVO notice) {
		// TODO Auto-generated method stub
		return noticeMapper.modify(notice);
	}

	// 삭제
	@Override
	public int delete(NoticeVO notice) {
		 
		return noticeMapper.delete(notice);
	}

	
	// 게시판 목록 페이징 적용
	@Override
	public List<NoticeVO> getListPaging(Criteria_2 cri) {
		// TODO Auto-generated method stub
		return noticeMapper.getListPaging(cri);
	}

	
	// 게시판 목록 총 개수
	@Override
	public int getTotal(Criteria_2 cri) {
		// TODO Auto-generated method stub
		return noticeMapper.getTotal(cri);
	}


	
	

}
