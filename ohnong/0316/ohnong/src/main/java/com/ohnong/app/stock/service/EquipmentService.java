package com.ohnong.app.stock.service;

import java.util.List;

public interface EquipmentService {
	
	//농기구목록 리스트(페이징) 조회
	public List<EquipmentVO> getEquipmentListWithPaging(Criteria_3 cri);
	//농기구목록 개수 조회
	public int getTotalCount(Criteria_3 cri);
	//농기구 등록
	public int equipmentInsert(EquipmentVO vo);
	//농기구 수정
	public int equipmentUpdate(EquipmentVO vo);
	//농기구 삭제
	public int equipmentDelete(String itemCode);
	//농기구 기존품목 등록
	public List<EquipmentVO> equipmentListWithMiddle(EquipmentVO vo);
	//선택 농기구 수량 및 창고번호반환
	public EquipmentVO getCount(EquipmentVO vo);
	//농기구 기존품목 등록
	public int equipmentnotInsert(EquipmentVO vo);
	//파손 농기구 리스트 조회
	public List<EquipmentVO> getBreakEquipmentListWithPaging(Criteria_3 cri);
}
