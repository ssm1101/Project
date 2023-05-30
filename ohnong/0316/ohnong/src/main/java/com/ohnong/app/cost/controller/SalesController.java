package com.ohnong.app.cost.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohnong.app.cost.service.Criteria_4;
import com.ohnong.app.cost.service.PageDTO_4;
import com.ohnong.app.cost.service.SalesService;
import com.ohnong.app.stock.service.SalesVO;

//seungmin 매출관리
@Controller
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	//매출 합계리스트
	@GetMapping("/salesList")
	public String getSalesList(Criteria_4 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		
		session.setAttribute(id, "user2");
		System.out.println(id);
		cri.setUserId(id);
		System.out.println(cri);
		List<SalesVO> totalSalesList = salesService.totalSales(cri);
		
		model.addAttribute("totalSalesList", totalSalesList);
		
		return "content/costAndSales/salesList";
	}
	
	@GetMapping("/getSales")
	@ResponseBody
	public SalesVO getSales(Criteria_4 cri, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<SalesVO> totalSalesList = salesService.totalSales(cri);
		SalesVO vo = new SalesVO();
		if(totalSalesList.size() != 0) {
			vo.setMiddleCatagori(totalSalesList.get(0).getMiddleCatagori());
		}
		
		return vo;
	}
	
	//매출 리스트
	@RequestMapping("/salesListWithPaging/{middleCategori}/{pageNum}")
	@ResponseBody
	public List<SalesVO> getSalesListWithPaging(@PathVariable("middleCategori") String middleCategori,
												@PathVariable("pageNum") int pageNum, 
												HttpSession session){
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setPageNum(pageNum);
		cri.setMiddleCategori(middleCategori);
		
		return salesService.getSalesListWithPaging(cri);
	}
	
	//매출 리스트 개수
	@RequestMapping("/TotalCount/{middleCategori}/{pageNum}")
	@ResponseBody
	public PageDTO_4 getTotalCount(@PathVariable("middleCategori") String middleCategori,
								   @PathVariable("pageNum") int pageNum, 
								   HttpSession session) {
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setPageNum(pageNum);
		cri.setMiddleCategori(middleCategori);
		int totalCount = salesService.getTotalCount(cri);
		
		return new PageDTO_4(cri, totalCount); 
	}
	
	//매출 리스트
	@RequestMapping("/salesListWithPagingDate/{middleCategori}/{startDate}/{endDate}/{pageNum}")
	@ResponseBody
	public List<SalesVO> getSalesListWithPagingDate(@PathVariable("middleCategori") String middleCategori,
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
		
		return salesService.getSalesListWithPagingDate(cri);
	}
	
	//매출 리스트 개수
	@RequestMapping("/TotalCountDate/{middleCategori}/{startDate}/{endDate}/{pageNum}")
	@ResponseBody
	public PageDTO_4 getTotalCountDate(@PathVariable("middleCategori") String middleCategori,
									   @PathVariable("startDate") String startDate,
									   @PathVariable("endDate") String endDate,
									   @PathVariable("pageNum") int pageNum, 
									   HttpSession session) {
		String id = (String)session.getAttribute("userId");
		Criteria_4 cri = new Criteria_4();
		cri.setUserId(id);
		cri.setMiddleCategori(middleCategori);
		cri.setStartDate(startDate);
		cri.setEndDate(endDate);
		cri.setPageNum(pageNum);
		int totalCount = salesService.getTotalCountDate(cri);
		
		return new PageDTO_4(cri, totalCount);
	}
}
