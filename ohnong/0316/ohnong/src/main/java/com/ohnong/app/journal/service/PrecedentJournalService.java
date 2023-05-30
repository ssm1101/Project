package com.ohnong.app.journal.service;

import java.util.List;


public interface PrecedentJournalService {

	public List<PrecedentJournalVO> precedentCropList();
	
	public List<PrecedentJournalVO>CropMaster(String cropName);
	
	public List<PrecedentPlanVO>CropMasterPlan(String cropMaster);
	
	public List<PrecedentJournalVO>CropMasterPlanList(String cropMaster);
	
	public List<PrecedentJournalVO>CropMasterListInfo(String cropMaster,String planDate);
	
	
}
