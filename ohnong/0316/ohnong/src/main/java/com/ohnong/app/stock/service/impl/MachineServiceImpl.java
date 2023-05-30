package com.ohnong.app.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.stock.mapper.MachineMapper;
import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.MachineService;
import com.ohnong.app.stock.service.MachineVO;
import com.ohnong.app.stock.service.NeighborVO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	private MachineMapper machineMapper;

	@Override
	public List<MachineVO> getMachineListWithPaging(Criteria_3 cri) {
		return machineMapper.getMachineListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria_3 cri) {
		return machineMapper.getTotalCount(cri);
	}

	@Override
	public int machineUpdate(MachineVO vo) {
		return machineMapper.machineUpdate(vo);
	}

	@Override
	public int machineDelete(String itemCode) {
		return machineMapper.machineDelete(itemCode);
	}

	@Override
	public int machineReturn(String itemCode) {
		return machineMapper.machineReturn(itemCode);
	}

	@Override
	public int machineInsert(MachineVO vo) {
		return machineMapper.machineInsert(vo);
	}

	@Override
	public List<NeighborVO> getneighborListWithPaging(Criteria_3 cri) {
		return machineMapper.getneighborListWithPaging(cri);
	}

	@Override
	public int neighborStatusUpdate(NeighborVO nvo) {
		return machineMapper.neighborStatusUpdate(nvo);
	}
	
	@Override
	public int neighborStatusDisUpdate(NeighborVO nvo) {
		return machineMapper.neighborStatusDisUpdate(nvo);
	}
	
	@Override
	public List<MachineVO> machineListWithMiddle(MachineVO vo) {
		return machineMapper.machineListWithMiddle(vo);
	}

	@Override
	public MachineVO getCount(MachineVO vo) {
		return machineMapper.getCount(vo);
	}
	
	@Override
	public int machinenotInsert(MachineVO vo) {
		return machineMapper.machinenotInsert(vo);
	}
	
	@Override
	public int machineInsertnotSubdivision(MachineVO vo) {
		return machineMapper.machineInsertnotSubdivision(vo);
	}
	@Override
	public List<NeighborVO> submitMachineList(String userId) {
		return machineMapper.submitMachineList(userId);
	}

	// #관리자용
	// 우리 동네 농기계 - 조회
	@Override
	public List<NeighborVO> neighborhoodRentalList() {
		return machineMapper.neighborhoodRentalList();
	}

	// 우리 동네 농기계 - 승인
	@Override
	public int changeState(NeighborVO nVO) {
		return machineMapper.changeState(nVO);
	}
	
	@Override
	public int changeState2(MachineVO mvo) {
		return machineMapper.changeState2(mvo);
	}

	// 우리 동네 농기계 - 수정
	@Override
	public boolean rentalMod(NeighborVO nVO) {
		return machineMapper.rentalUpdate(nVO) == 1 ? true : false;
	}

	// 우리 동네 농기계 - 삭제
	@Override
	public int rentalDelete(int no) {
		return machineMapper.deleteRental(no);
	}

	// 우리 동네 농기계 - 등록
	@Override
	public int insertRental(NeighborVO nVO) {
		return machineMapper.insertRental(nVO);
	}


}
