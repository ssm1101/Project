package com.ohnong.app.stock.service;

import java.util.List;

public interface CropService {

	// 작물 목록
	List<CropVO> getcropList(String userId);

	// 작물 수정
	boolean cropMod(CropVO cropVO);

	// 작물 삭제(업데이트)
	int cropInfoDelete(int cropNo);

	// 작물 등록
	int insertCrop(CropVO cropVO);

	// 작물 중복 확인
	int checkCrop(String name, String userId);

}
