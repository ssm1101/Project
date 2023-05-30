package com.ohnong.app.cost.mapper;

import java.util.List;

import com.ohnong.app.cost.service.CostVO;
import com.ohnong.app.cost.service.Criteria_4;

public interface CostMapper {
	
	//지출 리스트
	public List<CostVO> getCostListWithPaging(Criteria_4 cri);
	//지출 날짜별 리스트
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
