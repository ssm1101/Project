package com.ohnong.app.farm.mapper;

import java.util.List;

import com.ohnong.app.farm.service.FarmVO;
import com.ohnong.app.main.service.MemberVO;

public interface FarmMapper {

	// 농가 등록
	public int insertFarmInfo(FarmVO farmVO);

	// 본인 농가 조회
	public FarmVO selectFarmInfo(String userId);

	// 본인 농가 수정
	public int farmUpdate(FarmVO farmVO);

	// 관리자용 농가 조회
	public List<FarmVO> farmList();

	// 관리자용 농가 승인
	public int signFarmState(FarmVO farmVO);

	// 관리자용 농가 삭제 + 회원용 농가 탈퇴
	public int farmDelete(String userId);

	// 농가 중복 체크
	public int checkFarm(String farmName);
	
}
