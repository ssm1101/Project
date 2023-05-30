package com.ohnong.app.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.HarvestService;
import com.ohnong.app.stock.service.HarvestVO;
import com.ohnong.app.stock.service.PageDTO_3;
import com.ohnong.app.stock.service.SalesVO;
import com.ohnong.app.stock.service.WarehouseVO;

//seungmin 작물관리
@Controller
public class HarvestController {
	
	@Autowired
	HarvestService harvestService;
	
	//수확물리스트
	@GetMapping("/harvestList")
	public String getHarvestList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		
		System.out.println(cri);
		int totalCount = harvestService.getTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		model.addAttribute("harvestList", harvestService.getHarvestListWithPaging(cri));
		model.addAttribute("harvestListTotal", harvestService.harvestListCount(cri));
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("warehouseList", warehouseList);
		
		return "content/stock/harvestList";
	}
	
	//창고리스트
	@GetMapping("/warehouseList/{userId}")
	@ResponseBody	
	public List<WarehouseVO> getWarehouseList(@PathVariable("userId") String userId) {
		//본인여부확인필요
		return harvestService.getWarehouseList(userId); 
	}
	
	//수확물수정
	@PostMapping("/harvestUpdate")
	@ResponseBody
	public String harvestUpdate(HarvestVO vo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		harvestService.harvestUpdate(vo);
		return "true";
	}
	
	//수확물삭제
	@GetMapping("/harvestDelete/{harvestNo}")
	@ResponseBody
	public String harvestDelete(@PathVariable("harvestNo") int harvestNo) {
		int result = harvestService.harvestDelete(harvestNo);
		String message = "";
		if(result>0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}
	
	//작물리스트
	@GetMapping("/cropList/{middleCatagori}")
	@ResponseBody
	public List<HarvestVO> getCropList(@PathVariable("middleCatagori") String middleCatagori, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		HarvestVO vo = new HarvestVO();
		vo.setUserId(id);
		vo.setMiddleCatagori(middleCatagori);
		return harvestService.getCropList(vo); 
	}
	
	//수확물등록
	@PostMapping("/harvestInsert")
	public String harvestInsert(HarvestVO vo, HttpSession session) {
		if(vo.getDefect() == "") {
			vo.setDefectiveCount(0);
		} else {
			int defectiveCount = Integer.parseInt(vo.getDefect());
			vo.setDefectiveCount(defectiveCount);
		}
		
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		System.out.println(vo);
		harvestService.harvestInsert(vo);
		
		return "redirect:harvestList";
	}
	
	//불량품 목록
	@GetMapping("/defectiveList")
	public String getDefectiveList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<HarvestVO> defectiveList = harvestService.getDefectiveListWithPaging(cri);
		int totalCount = harvestService.getDefectiveTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		
		model.addAttribute("defectiveListTotal", harvestService.defectListCount(cri));
		model.addAttribute("defectiveList", defectiveList);
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("warehouseList", warehouseList);
		
		return "content/stock/defectiveList";
	}
	
	//불량품 수정
	@PostMapping("/defectiveUpdate")
	@ResponseBody
	public String defectiveUpdate(HarvestVO vo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		harvestService.defectiveUpdate(vo);
		
		return "true";
	}
	
	//불량품 삭제
	@GetMapping("/defectiveDelete/{defectiveNo}")
	@ResponseBody
	public String defectiveDelete(@PathVariable("defectiveNo") int defectiveNo) {
		int result = harvestService.defectiveDelete(defectiveNo);
		String message = "";
		System.out.println(result);
		if(result>0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}
	
	//중분류 선택시 작물목록
	@GetMapping("/selectHarvestList/{middleCatagori}")
	@ResponseBody
	public List<HarvestVO> SelectHarvestList(@PathVariable("middleCatagori") String middleCatagori, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		HarvestVO vo = new HarvestVO();
		vo.setUserId(id);
		vo.setMiddleCatagori(middleCatagori);
		return harvestService.selectHarvestList(vo); 
	}
	
	//품목 선택시 남은개수 반환
	@GetMapping("/selectHarvestListWithCrop/{cropNo}")
	@ResponseBody
	public HarvestVO SelectHarvestListWithCrop(@PathVariable("cropNo") int cropNo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		HarvestVO vo = new HarvestVO();
		vo.setUserId(id);
		vo.setCropNo(cropNo);
		return harvestService.selectHarvestListWithCrop(vo);
	}
	
	//수확물 출고
	@PostMapping("/harvestRelease")
	public String harvestRelease(SalesVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		System.out.println(vo);
		
		//매출 등록
		harvestService.salesInsert(vo);
		
		//가진수량 확인
		HarvestVO hvo = harvestService.harvestCount(vo);
		int count = hvo.getCount();
		
		//입력수량
		int inputCount = vo.getAmount();
		
		while(true) {
			//가진수량 < 입력수량
			if(count <= inputCount) {
				harvestService.harvestDeleteByCropNo(vo);
				inputCount = inputCount - count;
				
				//가진수량이 없는경우 break
				hvo = harvestService.harvestCount(vo);
				if(hvo == null) {
					break;
				}
				count = hvo.getCount();
			}
			//가진수량 > 입력수량
			if(count > inputCount) {
				vo.setAmount(inputCount);
				harvestService.harvestRelease(vo);
				
				//입력수량이 가진수량보다 작을경우 입력수량애 0입력
				if(inputCount < count ) {
					inputCount = 0;
				} else if(inputCount > count){
					inputCount = inputCount - count;
				}
			}
			//입력수량 <= 0일때 break
			if(inputCount == 0) {
				break;
			}
		}
		
		return "redirect:harvestList";
	}
 }
