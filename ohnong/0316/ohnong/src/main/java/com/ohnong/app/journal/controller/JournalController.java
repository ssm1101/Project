package com.ohnong.app.journal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.ohnong.app.journal.service.FarmJournalVO;
import com.ohnong.app.journal.service.JournalService;
import com.ohnong.app.journal.service.JournalVO;

@Controller
public class JournalController {
	
	@Autowired
	JournalService journalService;
	
	@GetMapping("/journal")
	public String main() {
		return "content/journal/journal";
	}
	
	@GetMapping("cropList")
	@ResponseBody
	public List<JournalVO> cropList(@RequestParam("userId") String userId) {
		
		System.out.println(userId);
		List<JournalVO> vo = journalService.cropList(userId);
		System.out.println(vo);
		return vo;
	}
	
	@GetMapping("cropPlan")
	@ResponseBody
	public List<JournalVO> cropPlan(@RequestParam("name") String name) {
		System.out.println("-----");
		System.out.println(name);
		
		List<JournalVO> vo = journalService.cropPlan(name);
		return vo;
	}
	
	@GetMapping("cropCode")
	@ResponseBody
	public String cropCode(@RequestParam("cropCode") String cropCode) {
		System.out.println(cropCode);
		return journalService.cropCode(cropCode);
	}
	
	@PostMapping("planAdd")
	@ResponseBody
	public int planAdd(@RequestBody JournalVO journalVO) {
	    int reuslt = journalService.planAdd(journalVO);	
	    return reuslt;
	}
	
	@PostMapping("planMod")
	@ResponseBody
	public int planMod(@RequestBody JournalVO journalVO) {
	    System.out.println(journalVO);
	    int result = journalService.planMod(journalVO);
	    return result;
	}
	
	@GetMapping("planDel")
	@ResponseBody
	public int planDel(@RequestParam("planNo") int planNo) {
		
		System.out.println(planNo);
		int result = journalService.planDel(planNo);
		return result;
	}
	
	@GetMapping("planList")
	@ResponseBody
	public List<FarmJournalVO> planList(@RequestParam("userId") String userId, @RequestParam("name") String cropName){
		
		List<FarmJournalVO> vo = journalService.planList(userId, cropName);
		System.out.println(vo);
		return vo;
	}
	
	@PostMapping("planListInfo")
	@ResponseBody
	public List<FarmJournalVO> planListInfo(@RequestParam("userId") String userId, @RequestParam("name") String cropName,@RequestParam("planDate") String planDate){
		
		System.out.println(userId);
		List<FarmJournalVO> vo = journalService.planListInfo(userId,cropName,planDate);
		return vo;
	}
	@PostMapping("DelPlan")
	@ResponseBody
	public RedirectView delPlan(@RequestParam("userId") String userId,@RequestParam("planDate") String planDate) {
		
		journalService.delPlan(userId,planDate);
		
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/ohnong/journal");
	    return redirectView;
	}

	
	@ResponseBody
	@RequestMapping(value="/uploadPlan", method = RequestMethod.POST)
	public RedirectView uploadPlan( Model model,@Valid FarmJournalVO farmJournalVO,BindingResult bindingResult,
	                                @RequestParam MultipartFile planImage,HttpServletRequest request) throws IOException{
	    String uploadDir = "/etc/";

	    if (planImage == null || planImage.isEmpty()) {
	        String nullImage = "/etc/이미지샘플.PNG";
	        farmJournalVO.setFilePath(nullImage);
	        System.out.println(farmJournalVO);
	        int result = journalService.uploadPlan(farmJournalVO);
	        System.out.println(result);

	        RedirectView redirectView = new RedirectView();
	        redirectView.setUrl("/ohnong/journal");
	        return redirectView;
	    }

	    String fileName = planImage.getOriginalFilename();
	    Path path = Paths.get(uploadDir + fileName);
	    Files.write(path, planImage.getBytes());
	    String filePath = uploadDir + fileName;
	    farmJournalVO.setFilePath(filePath);
	    System.out.println(farmJournalVO);
	    int result = journalService.uploadPlan(farmJournalVO);
	    System.out.println(result);

	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/ohnong/journal");
	    return redirectView;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/upDatePlan", method = RequestMethod.POST)
	public RedirectView upDatePlan(Model model, @Valid FarmJournalVO farmJournalVO, BindingResult bindingResult,
	        @RequestParam MultipartFile planImage, HttpServletRequest request) throws IOException{
	    
		String uploadDir = "/etc/";
	    
	    if (planImage == null || planImage.isEmpty()) {
	    	journalService.upDatePlan(farmJournalVO);
		    RedirectView redirectView = new RedirectView();
		    
	        redirectView.setUrl("/ohnong/journal");
		    return redirectView;
	    }
	    	
		    String fileName = planImage.getOriginalFilename();
		    Path path = Paths.get(uploadDir + fileName);
		    Files.write(path, planImage.getBytes());
		    String filePath = uploadDir + fileName;
		    farmJournalVO.setFilePath(filePath);
		    System.out.println(farmJournalVO);
		    int result = journalService.upDatePlan(farmJournalVO);
		    System.out.println(result);
		    
		    RedirectView redirectView = new RedirectView();
	        redirectView.setUrl("/ohnong/journal");
		    return redirectView;
	 
	}
	
}
