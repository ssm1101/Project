package com.ohnong.app.journal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohnong.app.journal.service.PrecedentJournalService;
import com.ohnong.app.journal.service.PrecedentJournalVO;
import com.ohnong.app.journal.service.PrecedentPlanVO;

@Controller
public class precedentJournalController {
	
	@Autowired
	PrecedentJournalService precedentJournalService;
	
	@GetMapping("/precedentJournal")
	public String precedentJournal() {
		return "content/journal/precedentJournal";
	}
	
	@GetMapping("/precedentCropList")
	@ResponseBody
	public List<PrecedentJournalVO> precedentCropList(){
		
		List<PrecedentJournalVO> vo = precedentJournalService.precedentCropList();
		
		return vo;
	}
	
	@GetMapping("/CropMaster")
	@ResponseBody
	public List<PrecedentJournalVO>CropMaster(@RequestParam("cropName") String cropName){
		
		List<PrecedentJournalVO> vo = precedentJournalService.CropMaster(cropName);
		
		return vo;
	}
	
	@GetMapping("/CropMasterPlan")
	@ResponseBody
	public List<PrecedentPlanVO>CropMasterPlan(@RequestParam("cropMaster") String cropMaster){
		
		System.out.println(cropMaster);
		List<PrecedentPlanVO> vo = precedentJournalService.CropMasterPlan(cropMaster);
		
		return vo;
	}
	
	@GetMapping("/CropMasterPlanList")
	@ResponseBody
	public List<PrecedentJournalVO>CropMasterPlanList(@RequestParam("cropMaster") String cropMaster){
		
		System.out.println(cropMaster);
		List<PrecedentJournalVO> vo = precedentJournalService.CropMasterPlanList(cropMaster);
		
		return vo;
	}
	
	@PostMapping("/CropMasterListInfo")
	@ResponseBody
	public List<PrecedentJournalVO>CropMasterListInfo(@RequestParam("cropMaster") String cropMaster,@RequestParam("planDate") String planDate){
		
		List<PrecedentJournalVO> vo = precedentJournalService.CropMasterListInfo(cropMaster, planDate);
		System.out.println(vo);
		return vo;
	}
}
