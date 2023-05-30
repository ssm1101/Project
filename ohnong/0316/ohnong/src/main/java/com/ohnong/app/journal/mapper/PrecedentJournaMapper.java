package com.ohnong.app.journal.mapper;

import java.util.List;

import com.ohnong.app.journal.service.PrecedentJournalVO;
import com.ohnong.app.journal.service.PrecedentPlanVO;

public interface PrecedentJournaMapper {
	
	public List<PrecedentJournalVO> precedentCropList();
	
	public List<PrecedentJournalVO> CropMaster(String cropName);
	
	public List<PrecedentPlanVO>CropMasterPlan(String cropMaster);

	public List<PrecedentJournalVO>CropMasterPlanList(String cropMaster);
	
	public List<PrecedentJournalVO>CropMasterListInfo(String cropMaster,String planDate);
}
