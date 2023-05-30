package com.ohnong.app.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohnong.app.farm.mapper.FarmAttachMapper;
import com.ohnong.app.farm.mapper.FarmMapper;
import com.ohnong.app.farm.service.FarmAttachVO;
import com.ohnong.app.farm.service.FarmService;
import com.ohnong.app.farm.service.FarmVO;
import com.ohnong.app.main.service.MemberVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FarmServiceImpl implements FarmService {

	@Autowired
	FarmMapper farmMapper;

	// 농가 등록
	@Transactional
	@Override
	public void insertFarmInfo(FarmVO farmVO) {
		farmMapper.insertFarmInfo(farmVO);
	}

	// 본인 농가 조회
	@Override
	public FarmVO getFarmInfo(String userId) {
		return farmMapper.selectFarmInfo(userId);
	}

	// 본인 농가 수정
	@Override
	public boolean farmMod(FarmVO farmVO) {
		return farmMapper.farmUpdate(farmVO) == 1 ? true : false;
	}

	// 관리자용 농가 조회
	@Override
	public List<FarmVO> farmList() {
		return farmMapper.farmList();
	}

	// 관리자용 농가 승인
	@Override
	public int signFarmState(FarmVO farmVO) {
		return farmMapper.signFarmState(farmVO);
	}

	// 관리자용 농가 삭제 + 회원용 농가 탈퇴
	@Override
	public int farmDelete(String userId) {
		return farmMapper.farmDelete(userId);
	}

	// 농가 중복 체크
	@Override
	public int checkFarm(String farmName) {
		return farmMapper.checkFarm(farmName);
	}

}
