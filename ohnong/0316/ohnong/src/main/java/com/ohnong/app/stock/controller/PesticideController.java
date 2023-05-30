package com.ohnong.app.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.HarvestService;
import com.ohnong.app.stock.service.OtherVO;
import com.ohnong.app.stock.service.PageDTO_3;
import com.ohnong.app.stock.service.PesticideService;
import com.ohnong.app.stock.service.SeedService;
import com.ohnong.app.stock.service.WarehouseVO;

//seungmin 농약,비료관리
@Controller
public class PesticideController {
	
	@Autowired
	PesticideService pesticideService;
	
	@Autowired
	HarvestService harvestService;
	
	@Autowired
	SeedService seedService;
	
	//농약,비료리스트
	@GetMapping("/pesticideList")
	public String getPesticideList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<OtherVO> pesticideList = pesticideService.getPesticideListWithPaging(cri);
		int totalCount = pesticideService.getTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("pesticideList", pesticideList);
		model.addAttribute("warehouseList", warehouseList);
		
		return "content/stock/pesticide";
	}
	
	//농약,비료 등록
	@PostMapping("/pesticideInsert")
	public String pesticideInsert(OtherVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		
		List<OtherVO> list = seedService.seedListWithMiddle(vo);
		if(list.isEmpty()) {
			pesticideService.pesticideInsert(vo);
		} else {
			seedService.seednotInsert(vo);
		}
		
		return "redirect:pesticideList";
	}
}
