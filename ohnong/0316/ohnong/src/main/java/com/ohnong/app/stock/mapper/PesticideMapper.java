package com.ohnong.app.stock.mapper;

import java.util.List;

import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.OtherVO;

public interface PesticideMapper {
	
	//농약, 비료 리스트(페이징) 조회
	public List<OtherVO> getPesticideListWithPaging(Criteria_3 cri);
	//농약, 비료 개수 조회
	public int getTotalCount(Criteria_3 cri);
	//농약, 비료 등록
	public int pesticideInsert(OtherVO vo);
}
