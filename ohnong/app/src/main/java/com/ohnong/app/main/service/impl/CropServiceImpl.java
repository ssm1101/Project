package com.ohnong.app.main.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.main.mapper.CropMapper;
import com.ohnong.app.main.service.CropService;
import com.ohnong.app.main.service.CropVO;

@Service
public class CropServiceImpl implements CropService {

	@Autowired
	CropMapper cropMapper;
	
	@Override
	public List<CropVO> getAllList() {
		return cropMapper.selectAllCropList();
	}

}
