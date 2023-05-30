package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.SeedMapper;
import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.OtherVO;
import com.ohnong.app.stock.service.SeedService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SeedServiceImpl implements SeedService {
	
	@Autowired
	private SeedMapper seedMapper;

	@Override
	public List<OtherVO> getSeedListWithPaging(Criteria_3 cri) {
		return seedMapper.getSeedListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_3 cri) {
		return seedMapper.getTotalCount(cri);
	}

	@Override
	public int seedUpdate(OtherVO vo) {
		return seedMapper.seedUpdate(vo);
	}

	@Override
	public int seedDelete(OtherVO vo) {
		return seedMapper.seedDelete(vo);
	}

	@Override
	public int seedInsert(OtherVO vo) {
		return seedMapper.seedInsert(vo);
	}

	@Override
	public OtherVO findSubdivision(OtherVO vo) {
		return seedMapper.findSubdivision(vo);
	}

	@Override
	public List<OtherVO> seedListWithMiddle(OtherVO vo) {
		return seedMapper.seedListWithMiddle(vo);
	}

	@Override
	public int seednotInsert(OtherVO vo) {
		return seedMapper.seednotInsert(vo);
	}

	@Override
	public OtherVO getCount(OtherVO vo) {
		return seedMapper.getCount(vo);
	}

}
