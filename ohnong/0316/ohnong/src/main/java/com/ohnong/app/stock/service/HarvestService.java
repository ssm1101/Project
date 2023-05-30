package com.ohnong.app.stock.service;

import java.util.List;

public interface HarvestService {
	
	//물품목록 조회
	public List<HarvestVO> getHarvestList();
	//물폼목록리스트(페이징) 조회
	public List<HarvestVO> getHarvestListWithPaging(Criteria_3 cri);
	//물품목록 개수 조회
	public int getTotalCount(Criteria_3 cri);
	//창고리스트 조회
	public List<WarehouseVO> getWarehouseList(String userId);
	//물품수정
	public int harvestUpdate(HarvestVO vo);
	//물품삭제
	public int harvestDelete(int harvestNo);
	//작물리스트 조회
	public List<HarvestVO> getCropList(HarvestVO vo);
	//입고 등록
	public int harvestInsert(HarvestVO vo);
	//불량목록리스트(페이징)조회
	public List<HarvestVO> getDefectiveListWithPaging(Criteria_3 cri);
	//불량목록리스트 개수 조회
	public int getDefectiveTotalCount(Criteria_3 cri);
	//불량수정
	public int defectiveUpdate(HarvestVO vo);
	//불량삭제
	public int defectiveDelete(int harvestNo);
	//중분류 선택시 작물목록
	public List<HarvestVO> selectHarvestList(HarvestVO vo);
	//품목 선택시 남은개수반환
	public HarvestVO selectHarvestListWithCrop(HarvestVO vo);
	//출고 - update harvest
	public int harvestRelease(SalesVO vo);
	//출고 - insert sales
	public int salesInsert(SalesVO vo);
	//출고 - delete harvest
	public int harvestDeleteByCropNo(SalesVO vo);
	//출고 - select count
	public HarvestVO harvestCount(SalesVO vo);
	//수확물 재고 품목명별 총계
	public List<HarvestVO> harvestListCount(Criteria_3 cri);
	//불량품목 재고 품목명별 총계
	public List<HarvestVO> defectListCount(Criteria_3 cri);
}
