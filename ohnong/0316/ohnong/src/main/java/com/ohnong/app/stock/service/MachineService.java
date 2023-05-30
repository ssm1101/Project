package com.ohnong.app.stock.service;

import java.util.List;

public interface MachineService {
	
	//농기계 리스트 조회
	public List<MachineVO> getMachineListWithPaging(Criteria_3 cri);
	//농기계 리스트 개수
	public int getTotalCount(Criteria_3 cri);
	//농기계 수정
	public int machineUpdate(MachineVO vo);
	//농기계 삭제
	public int machineDelete(String itemCode);
	//농기계 반납
	public int machineReturn(String itemCode);
	//농기계 수동 등록
	public int machineInsert(MachineVO vo);
	//농기계 대여리스트 목록
	public List<NeighborVO> getneighborListWithPaging (Criteria_3 cri);
	//대여리스트 대여신청
	public int neighborStatusUpdate(NeighborVO nvo);
	//대여리스트 대여취소
	public int neighborStatusDisUpdate(NeighborVO nvo);
	//기존 등록 리스트
	public List<MachineVO> machineListWithMiddle(MachineVO vo);
	//선택 농기계 정보
	public MachineVO getCount(MachineVO vo);
	//등록된 농기계 등록시
	public int machinenotInsert(MachineVO vo);
	//등록된 농기계 등록시
	public int machineInsertnotSubdivision(MachineVO vo);
	//대여신청 농기계 목록
	public List<NeighborVO> submitMachineList(String userId);
	
	// #관리자용
	// 우리 동네 농기계 - 조회
	public List<NeighborVO> neighborhoodRentalList();
	
	// 우리 동네 농기계 - 승인
	public int changeState(NeighborVO nVO);
	public int changeState2(MachineVO mvo);
	
	// 우리 동네 농기계 - 수정
	public boolean rentalMod(NeighborVO nVO);
	
	// 우리 동네 농기계 - 삭제
	public int rentalDelete(int no);
	
	// 우리 동네 농기계 - 등록
	public int insertRental(NeighborVO nVO);
}
