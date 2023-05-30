package com.ohnong.app.cost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.cost.mapper.SalesMapper;
import com.ohnong.app.cost.service.Criteria_4;
import com.ohnong.app.cost.service.SalesService;
import com.ohnong.app.stock.service.SalesVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	SalesMapper salesMapper;

	@Override
	public List<SalesVO> getSalesListWithPaging(Criteria_4 cri) {
		return salesMapper.getSalesListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_4 cri) {
		return salesMapper.getTotalCount(cri);
	}

	@Override
	public List<SalesVO> totalSales(Criteria_4 cri) {
		return salesMapper.totalSales(cri);
	}

	@Override
	public List<SalesVO> getSalesListWithPagingDate(Criteria_4 cri) {
		return salesMapper.getSalesListWithPagingDate(cri);
	}

	@Override
	public int getTotalCountDate(Criteria_4 cri) {
		return salesMapper.getTotalCountDate(cri);
	}
}
