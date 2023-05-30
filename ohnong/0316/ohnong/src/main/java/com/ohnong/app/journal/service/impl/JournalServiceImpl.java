package com.ohnong.app.journal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.journal.mapper.JournalMapper;
import com.ohnong.app.journal.service.FarmJournalVO;
import com.ohnong.app.journal.service.JournalService;
import com.ohnong.app.journal.service.JournalVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JournalServiceImpl implements JournalService {
	
	@Autowired
	JournalMapper journalMapper;

	@Override
	public List<JournalVO> cropList(String userId) {
		// TODO Auto-generated method stub
		return journalMapper.cropList(userId);
	}

	@Override
	public List<JournalVO> cropPlan(String name) {
		// TODO Auto-generated method stub
		return journalMapper.cropPlan(name);
	}

	@Override
	public String cropCode(String cropCode) {
		// TODO Auto-generated method stub
		return journalMapper.cropCode(cropCode);
	}

	@Override
	public int planAdd(JournalVO journalVO) {
		// TODO Auto-generated method stub
		return journalMapper.planAdd(journalVO);
	}

	@Override
	public int planMod(JournalVO journalVO) {
		// TODO Auto-generated method stub
		return journalMapper.planMod(journalVO);
	}

	@Override
	public int planDel(int planNo) {
		// TODO Auto-generated method stub
		return journalMapper.planDel(planNo);
	}

	@Override
	public int uploadPlan(FarmJournalVO farmJournalVO) {
		// TODO Auto-generated method stub
		return journalMapper.uploadPlan(farmJournalVO);
	}

	@Override
	public List<FarmJournalVO> planList(String userId, String cropName) {
		// TODO Auto-generated method stub
		return journalMapper.planList(userId, cropName);
	}

	@Override
	public List<FarmJournalVO> planListInfo(String userId, String cropName, String planDate) {
		// TODO Auto-generated method stub
		return journalMapper.planListInfo(userId, cropName, planDate);
	}

	@Override
	public int upDatePlan(FarmJournalVO farmJournalVO) {
		// TODO Auto-generated method stub
		return journalMapper.upDatePlan(farmJournalVO);
	}

	@Override
	public int delPlan(String userId, String planDate) {
		// TODO Auto-generated method stub
		return journalMapper.delPlan(userId, planDate);
	}
	
	

}
