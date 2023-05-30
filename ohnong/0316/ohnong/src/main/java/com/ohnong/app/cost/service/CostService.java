package com.ohnong.app.cost.service;

import java.util.List;

public interface CostService {
	
	//지출 날짜검색
	public List<CostVO> getCostListWithPaging(Criteria_4 cri);
	//지출 날짜별
	public List<CostVO> getCostListWithPagingDate(Criteria_4 cri);
	//지출 리스트 개수
	public int getTotalCount(Criteria_4 cri);
	//인건비 등록
	public int costInsert(CostVO vo);
	//지출 토탈 리스트
	public List<CostVO> totalCost(Criteria_4 cri);
	//지출 날짜별 리스트 개수
	public int getTotalCountDate(Criteria_4 cri);
	//지출 총 리스트
	public List<CostVO> costList(String id, String middleCategori);
}
