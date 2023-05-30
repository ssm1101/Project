package com.ohnong.app.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohnong.app.stock.service.WarehouseService;
import com.ohnong.app.stock.service.WarehouseVO;

@Controller
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;

	// 창고 목록
	@GetMapping("/warehouseList")
	public String warehouseList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<WarehouseVO> list = warehouseService.getwarehouseList(userId);
		System.out.println("목록" + list);
		model.addAttribute("warehouseList", list);
		return "content/stock/warehouseList";
	}

	// 창고 수정
	@PostMapping("/warehouseList")
	public String warehouseList(WarehouseVO warehouseVO, RedirectAttributes rttr) {
		if (warehouseService.warehouseMod(warehouseVO)) {
			System.out.println("변경 성공");
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("변경 실패");
			rttr.addFlashAttribute("result", "fail");
		}

		return "redirect:/warehouseList";
	}

	// 창고 삭제
	@GetMapping("/warehouseDelete/{warehouseCode}")
	@ResponseBody
	public String warehouseDelete(@PathVariable("warehouseCode") int warehouseCode) {
		int result = warehouseService.warehouseDelete(warehouseCode);
		String message = "";
		if (result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

	// 창고 등록
	@PostMapping("/warehouseAdd")
	public String warehouseAdd(WarehouseVO warehouseVO) {
		warehouseService.insertWarehouse(warehouseVO);
		return "redirect:/warehouseList";
	}

	// 창고 중복 확인
	@GetMapping("/checkWarehouse")
	@ResponseBody
	public String checkWarehouse(@RequestParam("warehouseName") String warehouseName, @RequestParam("userId") String userId) {
		int checkNum = warehouseService.checkWarehouse(warehouseName, userId);

		if (checkNum == 0) {
			System.out.println("등록 가능");
			return "available";
		} else {
			System.out.println("창고 중복");
			return "duplicated";
		}
	}
}
