package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.HarvestMapper;
import com.ohnong.app.stock.service.HarvestService;
import com.ohnong.app.stock.service.HarvestVO;

@Service
public class HarvestServiceImpl implements HarvestService {

	@Autowired
	HarvestMapper harvestMapper;
	
	@Override
	public List<HarvestVO> harvestAllList() {
		return harvestMapper.harvestAllList();
	}

}
