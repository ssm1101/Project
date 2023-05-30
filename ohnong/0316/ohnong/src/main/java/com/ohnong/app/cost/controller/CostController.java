package com.ohnong.app.cost.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohnong.app.cost.service.CostService;
import com.ohnong.app.cost.service.CostVO;
import com.ohnong.app.cost.service.Criteria_4;
import com.ohnong.app.cost.service.PageDTO_4;

//seungmin 지출관리
@Controller
public class CostController {
	
	@Autowired
	CostService costService;
	
	//지출 합계리스트
	@GetMapping("/costList")
	public String getCostList(Criteria_4 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		System.out.println(cri);
		List<CostVO> totalCostList = costService.totalCost(cri);
		System.out.println(totalCostList);
		
		model.addAttribute("totalCostList", totalCostList);
		
		return "content/costAndSales/costList";
	}
	
	@GetMapping("/getCost")
	@ResponseBody
	public CostVO getCost(Criteria_4 cri, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<CostVO> totalCostList = costService.totalCost(cri);
		CostVO vo = new CostVO();
		if(totalCostList.size() != 0){
			vo.setMiddleCategori(totalCostList.get(0).getMiddleCategori());
		}
		
		return vo;
	}
	
	//지출등록
	@PostMapping("/costInsert")
	public String costInsert(CostVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		costService.costInsert(vo);
		
		return "redirect:costList";
	}
	
	//지출리스트
	@RequestMapping("/costListWithPaging/{middleCategori}/{pageNum}")
	@ResponseBody
	public List<CostVO> costListWithPaging(@PathVariable("middleCategori") String middleCategori,
										   @PathVariable("pageNum") int pageNum,
										   HttpSession session,
										   Model model){
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setPageNum(pageNum);
		cri.setMiddleCategori(middleCategori);
		System.out.println(cri);
		
		//작물 리스트
		List<CostVO> cost = costService.costList(id,middleCategori);
		return costService.getCostListWithPaging(cri);
	}
	//지출리스트
	@RequestMapping("/costList/{middleCategori}")
	@ResponseBody
	public List<CostVO> costList(@PathVariable("middleCategori") String middleCategori,HttpSession session, Model model){
		//작물 리스트
		String id = (String)session.getAttribute("userId");
		List<CostVO> cost = costService.costList(id,middleCategori);
		return cost;
	}
	//지출리스트 개수
	@RequestMapping("/getTotalCount/{middleCategori}/{pageNum}")
	@ResponseBody
	public PageDTO_4 getTotalCount(@PathVariable("middleCategori") String middleCategori,
								   @PathVariable("pageNum") int pageNum,
								   HttpSession session) {
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setPageNum(pageNum);
		cri.setMiddleCategori(middleCategori);
		int totalCount = costService.getTotalCount(cri);
		return new PageDTO_4(cri, totalCount);
	}
	
	//지출리스트
	@RequestMapping("/costListWithPagingDate/{middleCategori}/{startDate}/{endDate}/{pageNum}")
	@ResponseBody
	public List<CostVO> costListWithPagingDate(@PathVariable("middleCategori") String middleCategori,
											   @PathVariable("startDate") String startDate,
											   @PathVariable("endDate") String endDate,
											   @PathVariable("pageNum") int pageNum, 
											   HttpSession session){
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setMiddleCategori(middleCategori);
		cri.setStartDate(startDate);
		cri.setEndDate(endDate);
		cri.setPageNum(pageNum);
		System.out.println(cri);
		return costService.getCostListWithPagingDate(cri);
	}
	
	//지출리스트 개수
	@RequestMapping("/getTotalCountDate/{middleCategori}/{startDate}/{endDate}/{pageNum}")
	@ResponseBody
	public PageDTO_4 getTotalCountDate(@PathVariable("middleCategori") String middleCategori,
									   @PathVariable("startDate") String startDate,
									   @PathVariable("endDate") String endDate,
								   	   @PathVariable("pageNum") int pageNum, 
								   	   HttpSession session) {
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setStartDate(startDate);
		cri.setEndDate(endDate);
		cri.setPageNum(pageNum);
		cri.setMiddleCategori(middleCategori);
		int totalCount = costService.getTotalCountDate(cri);
		return new PageDTO_4(cri, totalCount);
	}
	
	
}
