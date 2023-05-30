package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.HarvestMapper;
import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.HarvestService;
import com.ohnong.app.stock.service.HarvestVO;
import com.ohnong.app.stock.service.SalesVO;
import com.ohnong.app.stock.service.WarehouseVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HarvestServiceImpl implements HarvestService {

	@Autowired
	private HarvestMapper harvestMapper;
	
	@Override
	public List<HarvestVO> getHarvestList() {
		return harvestMapper.getHarvestList();
	}

	@Override
	public List<HarvestVO> getHarvestListWithPaging(Criteria_3 cri) {
		return harvestMapper.getHarvestListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_3 cri) {
		return harvestMapper.getTotalCount(cri);
	}

	@Override
	public List<WarehouseVO> getWarehouseList(String userId) {
		return harvestMapper.getWarehouseList(userId);
	}

	@Override
	public int harvestUpdate(HarvestVO vo) {
		return harvestMapper.harvestUpdate(vo);
	}

	@Override
	public int harvestDelete(int harvestNo) {
		return harvestMapper.harvestDelete(harvestNo);
	}

	@Override
	public List<HarvestVO> getCropList(HarvestVO vo) {
		return harvestMapper.getCropList(vo);
	}

	@Override
	public int harvestInsert(HarvestVO vo) {
		return harvestMapper.harvestInsert(vo);
	}

	@Override
	public List<HarvestVO> getDefectiveListWithPaging(Criteria_3 cri) {
		return harvestMapper.getDefectiveListWithPaging(cri);
	}

	@Override
	public int getDefectiveTotalCount(Criteria_3 cri) {
		return harvestMapper.getDefectiveTotalCount(cri);
	}

	@Override
	public int defectiveUpdate(HarvestVO vo) {
		return harvestMapper.defectiveUpdate(vo);
	}

	@Override
	public int defectiveDelete(int harvestNo) {
		return harvestMapper.defectiveDelete(harvestNo);
	}

	@Override
	public List<HarvestVO> selectHarvestList(HarvestVO vo) {
		return harvestMapper.selectHarvestList(vo);
	}

	@Override
	public HarvestVO selectHarvestListWithCrop(HarvestVO vo) {
		return harvestMapper.selectHarvestListWithCrop(vo);
	}

	@Override
	public int harvestRelease(SalesVO vo) {
		return harvestMapper.harvestRelease(vo);
	}

	@Override
	public int salesInsert(SalesVO vo) {
		return harvestMapper.salesInsert(vo);
	}

	@Override
	public int harvestDeleteByCropNo(SalesVO vo) {
		return harvestMapper.harvestDeleteByCropNo(vo);
	}

	@Override
	public HarvestVO harvestCount(SalesVO vo) {
		return harvestMapper.harvestCount(vo);
	}

	@Override
	public List<HarvestVO> harvestListCount(Criteria_3 cri) {
		return harvestMapper.harvestListCount(cri);
	}

	@Override
	public List<HarvestVO> defectListCount(Criteria_3 cri) {
		return harvestMapper.defectListCount(cri);
	}

}
