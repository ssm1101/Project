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
import com.ohnong.app.stock.service.EquipmentService;
import com.ohnong.app.stock.service.EquipmentVO;
import com.ohnong.app.stock.service.HarvestService;
import com.ohnong.app.stock.service.PageDTO_3;
import com.ohnong.app.stock.service.WarehouseVO;

//seungmin 농기구관리
@Controller
public class EquipmentController {
	
	@Autowired
	EquipmentService equipmentService;
	
	@Autowired
	HarvestService harvestService;
	
	//농기구 리스트
	@GetMapping("/equipmentList")
	public String getEquipmentList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<EquipmentVO> equipmentList = equipmentService.getEquipmentListWithPaging(cri);
		int totalCount = equipmentService.getTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		List<EquipmentVO> breakEquipmentList = equipmentService.getBreakEquipmentListWithPaging(cri);
		
		model.addAttribute("breakEquipmentList", breakEquipmentList);
		model.addAttribute("equipmentList", equipmentList);
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("warehouseList", warehouseList);
		
		return "content/stock/equipment";
	}
	
	//농기구 등록
	@PostMapping("/equipmentInsert")
	public String equipmentInsert(EquipmentVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		List<EquipmentVO> list = equipmentService.equipmentListWithMiddle(vo);
		System.out.println(vo);
		if(list.isEmpty()) {
			equipmentService.equipmentInsert(vo);
		} else {
			equipmentService.equipmentnotInsert(vo);
		}
		
		return "redirect:equipmentList";
	}
	
	//농기구 수정
	@PostMapping("/equipmentUpdate")
	@ResponseBody
	public String equipmentUpdate(EquipmentVO vo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		equipmentService.equipmentUpdate(vo);
		
		return "true";
	}
	
	@GetMapping("/equipmentDelete/{itemCode}")
	@ResponseBody
	public String equipmentDelete(@PathVariable("itemCode") String itemCode) {
		equipmentService.equipmentDelete(itemCode);
		
		return "success";
	}
	
	//등록된 농기구 리스트
	@GetMapping("/equipmentListWithMiddle/{value}")
	@ResponseBody
	public List<EquipmentVO> equipmentListWithMiddle(@PathVariable("value") String middleCatagori, HttpSession session){
		String id = (String)session.getAttribute("userId");
		EquipmentVO vo = new EquipmentVO();
		vo.setUserId(id);
		vo.setMiddleCatagori(middleCatagori);
		List<EquipmentVO> list = equipmentService.equipmentListWithMiddle(vo);
		
		return list;
	}
	
	//선택농기구 정보
	@GetMapping("/getEquipmentCount/{name}")
	@ResponseBody
	public EquipmentVO getCount(@PathVariable("name") String name, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		EquipmentVO vo = new EquipmentVO();
		vo.setUserId(id);
		vo.setName(name);
		
		return equipmentService.getCount(vo);
	}
	
}
