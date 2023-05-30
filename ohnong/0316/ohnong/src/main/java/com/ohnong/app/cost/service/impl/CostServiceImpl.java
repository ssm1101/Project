package com.ohnong.app.cost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.cost.mapper.CostMapper;
import com.ohnong.app.cost.service.CostService;
import com.ohnong.app.cost.service.CostVO;
import com.ohnong.app.cost.service.Criteria_4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CostServiceImpl implements CostService {
	
	@Autowired
	CostMapper costMapper;

	@Override
	public List<CostVO> getCostListWithPaging(Criteria_4 cri) {
		return costMapper.getCostListWithPaging(cri);
	}
	
	@Override
	public List<CostVO> getCostListWithPagingDate(Criteria_4 cri) {
		return costMapper.getCostListWithPagingDate(cri);
	}
	
	@Override
	public int getTotalCount(Criteria_4 cri) {
		return costMapper.getTotalCount(cri);
	}

	@Override
	public int costInsert(CostVO vo) {
		return costMapper.costInsert(vo);
	}

	@Override
	public List<CostVO> totalCost(Criteria_4 cri) {
		return costMapper.totalCost(cri);
	}

	@Override
	public int getTotalCountDate(Criteria_4 cri) {
		return costMapper.getTotalCountDate(cri);
	}

	@Override
	public List<CostVO> costList(String id, String middleCategori) {
		// TODO Auto-generated method stub
		return costMapper.costList(id, middleCategori);
	}


	
}
