package com.ohnong.app.stock.mapper;

import java.util.List;

import com.ohnong.app.stock.service.CropVO;

public interface CropMapper {

	// 작물 전체 목록
	List<CropVO> getcropList(String userId);

	// 작물 수정
	int cropUpdate(CropVO cropVO);

	// 작물 삭제(업데이트)
	int deleteCrop(int cropNo);

	// 작물 등록
	int insertCrop(CropVO cropVO);

	// 작물 중복 확인
	int checkCrop(String name, String userId);
}
