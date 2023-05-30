package com.ohnong.app.stock.mapper;

import java.util.List;

import com.ohnong.app.stock.service.CropVO;
import com.ohnong.app.stock.service.WarehouseVO;

public interface WarehouseMapper {

	// 창고 목록
	List<WarehouseVO> getwarehouseList(String userId);

	// 창고 수정
	int warehouseUpdate(WarehouseVO warehouseVO);

	// 창고 삭제
	int deleteWarehouse(int warehouseCode);

	// 창고 등록
	int insertWarehouse(WarehouseVO warehouseVO);

	// 창고 중복 확인
	int checkWarehouse(String warehouseName, String userId);
}
