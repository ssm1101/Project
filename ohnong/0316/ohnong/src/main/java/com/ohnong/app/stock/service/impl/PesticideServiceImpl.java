package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.PesticideMapper;
import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.OtherVO;
import com.ohnong.app.stock.service.PesticideService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PesticideServiceImpl implements PesticideService {
	
	private PesticideMapper pesticideMapper;
	
	@Override
	public List<OtherVO> getPesticideListWithPaging(Criteria_3 cri) {
		return pesticideMapper.getPesticideListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_3 cri) {
		return pesticideMapper.getTotalCount(cri);
	}

	@Override
	public int pesticideInsert(OtherVO vo) {
		return pesticideMapper.pesticideInsert(vo);
	}
	
}
