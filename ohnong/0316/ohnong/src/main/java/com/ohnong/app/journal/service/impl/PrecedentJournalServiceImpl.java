package com.ohnong.app.journal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.journal.mapper.PrecedentJournaMapper;
import com.ohnong.app.journal.service.PrecedentJournalService;
import com.ohnong.app.journal.service.PrecedentJournalVO;
import com.ohnong.app.journal.service.PrecedentPlanVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrecedentJournalServiceImpl implements PrecedentJournalService{
	
	@Autowired
	PrecedentJournaMapper precedentJournaMapper;
	
	@Override
	public List<PrecedentJournalVO> precedentCropList() {
		// TODO Auto-generated method stub
		return precedentJournaMapper.precedentCropList();
	}

	@Override
	public List<PrecedentJournalVO> CropMaster(String cropName) {
		// TODO Auto-generated method stub
		return precedentJournaMapper.CropMaster(cropName);
	}

	@Override
	public List<PrecedentPlanVO> CropMasterPlan(String cropMaster) {
		// TODO Auto-generated method stub
		return precedentJournaMapper.CropMasterPlan(cropMaster);
	}

	@Override
	public List<PrecedentJournalVO> CropMasterPlanList(String cropMaster) {
		// TODO Auto-generated method stub
		return precedentJournaMapper.CropMasterPlanList(cropMaster);
	}

	@Override
	public List<PrecedentJournalVO> CropMasterListInfo(String cropMaster, String planDate) {
		// TODO Auto-generated method stub
		return precedentJournaMapper.CropMasterListInfo(cropMaster, planDate);
	}

}
