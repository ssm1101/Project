package com.ohnong.app.stock.service;

import java.util.List;

public interface WarehouseService {

	// 창고 목록
	List<WarehouseVO> getwarehouseList(String userId);

	// 창고 수정
	boolean warehouseMod(WarehouseVO warehouseVO);

	// 창고 삭제
	int warehouseDelete(int warehouseCode);

	// 창고 등록
	int insertWarehouse(WarehouseVO warehouseVO);

	// 창고 중복 확인
	int checkWarehouse(String warehouseName, String userId);

}
