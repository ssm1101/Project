package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.WarehouseMapper;
import com.ohnong.app.stock.service.WarehouseService;
import com.ohnong.app.stock.service.WarehouseVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	WarehouseMapper warehouseMapper;

	// 창고 목록
	@Override
	public List<WarehouseVO> getwarehouseList(String userId) {
		return warehouseMapper.getwarehouseList(userId);
	}

	// 창고 수정
	@Override
	public boolean warehouseMod(WarehouseVO warehouseVO) {
		return warehouseMapper.warehouseUpdate(warehouseVO) == 1 ? true : false;
	}

	// 창고 삭제
	@Override
	public int warehouseDelete(int warehouseCode) {
		return warehouseMapper.deleteWarehouse(warehouseCode);
	}

	// 창고 등록
	@Override
	public int insertWarehouse(WarehouseVO warehouseVO) {
		return warehouseMapper.insertWarehouse(warehouseVO);
	}

	// 창고 중복 확인
	@Override
	public int checkWarehouse(String warehouseName, String userId) {
		return warehouseMapper.checkWarehouse(warehouseName, userId);
	}
}
