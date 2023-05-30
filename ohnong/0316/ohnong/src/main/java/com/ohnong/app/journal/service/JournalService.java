package com.ohnong.app.journal.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface JournalService {

	//작물리스트 조회
	public List<JournalVO> cropList(String userId);
	
	//작물 계획 리스트
	public List<JournalVO> cropPlan(String name);
	
	//작물 코드 조회
	public String cropCode(String cropCode);
	
	//작물 계획 등록 
	public int planAdd(JournalVO journalVO);
	
	//작물 계획 수정
	public int planMod(JournalVO journalVO);
	
	//작물 계획 삭제
	public int planDel(int planNo);
	
	//작물 계획상세 작성
	public int uploadPlan(FarmJournalVO farmJournalVO);
	
	//작물 계획상세 리스트
	public List<FarmJournalVO> planList(String userId, String cropName);
	
	//작물 계획단건 조회
	public List<FarmJournalVO> planListInfo(String userId, String cropName, String planDate);
	
	//작물 계획상세 수정
	public int upDatePlan(FarmJournalVO farmJournalVO);
	
	//작물 계획상세 삭제
	public int delPlan(String userId,String planDate);
	
}
