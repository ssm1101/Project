package com.ohnong.app.stock.service;

import java.util.List;

public interface PesticideService {
	
	//농약, 비료 리스트(페이징) 조회
	public List<OtherVO> getPesticideListWithPaging(Criteria_3 cri);
	//농약, 비료 개수 조회
	public int getTotalCount(Criteria_3 cri);
	//농약, 비료 등록
	public int pesticideInsert(OtherVO vo);
}
