package com.ohnong.app.cost.mapper;

import java.util.List;

import com.ohnong.app.cost.service.Criteria_4;
import com.ohnong.app.stock.service.SalesVO;

public interface SalesMapper {
	
	//매출 목록 리스트
	public List<SalesVO> getSalesListWithPaging(Criteria_4 cri);
	//매출 목록 리스트 개수
	public int getTotalCount(Criteria_4 cri);
	//매출 토탈 리스트
	public List<SalesVO> totalSales(Criteria_4 cri);
	//매출 목록 리스트
	public List<SalesVO> getSalesListWithPagingDate(Criteria_4 cri);
	//매출 목록 리스트 개수
	public int getTotalCountDate(Criteria_4 cri);
}
