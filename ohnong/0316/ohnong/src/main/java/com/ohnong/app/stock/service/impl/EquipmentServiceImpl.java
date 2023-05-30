package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.EquipmentMapper;
import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.EquipmentService;
import com.ohnong.app.stock.service.EquipmentVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentMapper equipmentMapper;

	@Override
	public List<EquipmentVO> getEquipmentListWithPaging(Criteria_3 cri) {
		return equipmentMapper.getEquipmentListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_3 cri) {
		return equipmentMapper.getTotalCount(cri);
	}

	@Override
	public int equipmentInsert(EquipmentVO vo) {
		return equipmentMapper.equipmentInsert(vo);
	}

	@Override
	public int equipmentUpdate(EquipmentVO vo) {
		return equipmentMapper.equipmentUpdate(vo);
	}

	@Override
	public int equipmentDelete(String itemCode) {
		return equipmentMapper.equipmentDelete(itemCode);
	}

	@Override
	public List<EquipmentVO> equipmentListWithMiddle(EquipmentVO vo) {
		return equipmentMapper.equipmentListWithMiddle(vo);
	}

	@Override
	public EquipmentVO getCount(EquipmentVO vo) {
		return equipmentMapper.getCount(vo);
	}

	@Override
	public int equipmentnotInsert(EquipmentVO vo) {
		return equipmentMapper.equipmentnotInsert(vo);
	}

	@Override
	public List<EquipmentVO> getBreakEquipmentListWithPaging(Criteria_3 cri) {
		return equipmentMapper.getBreakEquipmentListWithPaging(cri);
	}

}
