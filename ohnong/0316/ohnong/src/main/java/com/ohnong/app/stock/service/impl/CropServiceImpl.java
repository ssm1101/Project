package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.CropMapper;
import com.ohnong.app.stock.service.CropService;
import com.ohnong.app.stock.service.CropVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CropServiceImpl implements CropService {

	@Autowired
	CropMapper cropMapper;

	// 작물 목록
	@Override
	public List<CropVO> getcropList(String userId) {
		return cropMapper.getcropList(userId);
	}

	// 작물 수정
	@Override
	public boolean cropMod(CropVO cropVO) {
		return cropMapper.cropUpdate(cropVO) == 1 ? true : false;
	}

	// 작물 삭제(업데이트)
	@Override
	public int cropInfoDelete(int cropNo) {
		return cropMapper.deleteCrop(cropNo);
	}

	// 작물 등록
	@Override
	public int insertCrop(CropVO cropVO) {
		return cropMapper.insertCrop(cropVO);
	}

	// 작물 중복 확인
	@Override
	public int checkCrop(String name, String userId) {
		return cropMapper.checkCrop(name, userId);
	}
}
