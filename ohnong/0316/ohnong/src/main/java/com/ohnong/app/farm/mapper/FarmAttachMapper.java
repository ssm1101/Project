package com.ohnong.app.farm.mapper;

import java.util.List; 

import com.ohnong.app.farm.service.FarmAttachVO;

public interface FarmAttachMapper {
	
	// 농가 등록
	public void insert(FarmAttachVO vo);

	// 농가 이름으로 첨부파일을 찾는 작업
	public List<FarmAttachVO> findByBno(String farmName);
}
