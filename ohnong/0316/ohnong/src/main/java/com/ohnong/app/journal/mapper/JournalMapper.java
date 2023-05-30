package com.ohnong.app.journal.mapper;import java.util.List;

import com.ohnong.app.journal.service.FarmJournalVO;
import com.ohnong.app.journal.service.JournalVO;

public interface JournalMapper {
	
	public List<JournalVO> cropList(String userId);
	
	//작물 계획리스트
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
	
	//작물 계획상세 수정
	public List<FarmJournalVO> planList(String userId, String cropName);
	
	//작물 계획단건 조회
	public List<FarmJournalVO> planListInfo(String userId, String cropName, String planDate);
	
	//작물 계획상세 수정
	public int upDatePlan(FarmJournalVO farmJournalVO);
	
	//작물 계획상세 삭제
	public int delPlan(String userId,String planDate);
}
