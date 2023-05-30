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

import com.ohnong.app.stock.service.CropService;
import com.ohnong.app.stock.service.CropVO;

@Controller
public class CropController {

	@Autowired
	CropService cropService;

	// 작물 목록
	@GetMapping("/cropInfoList")
	public String cropList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<CropVO> list = cropService.getcropList(userId);
		System.out.println("목록" + list);
		model.addAttribute("cropList", list);
		return "content/stock/cropInfoList";
	}

	// 작물 수정
	@PostMapping("/cropInfoList")
	public String cropInfoList(CropVO cropVO, RedirectAttributes rttr) {
		if (cropService.cropMod(cropVO)) {
			System.out.println("변경 성공");
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("변경 실패");
			rttr.addFlashAttribute("result", "fail");
		}

		return "redirect:/cropInfoList";
	}

	// 작물 삭제(업데이트)
	@GetMapping("/cropInfoDelete/{cropNo}")
	@ResponseBody
	public String cropInfoDelete(@PathVariable("cropNo") int cropNo) {
		int result = cropService.cropInfoDelete(cropNo);
		String message = "";
		if (result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

	// 작물 등록
	@PostMapping("/cropInfoAdd")
	public String cropInfoAdd(CropVO cropVO) {
		cropService.insertCrop(cropVO);
		return "redirect:/cropInfoList";
	}

	// 작물 중복 확인
	@GetMapping("/checkCrop")
	@ResponseBody
	public String checkCrop(@RequestParam("name") String name, @RequestParam("userId") String userId) {
		int checkNum = cropService.checkCrop(name, userId);

		if (checkNum == 0) {
			System.out.println("등록 가능");
			return "available";
		} else {
			System.out.println("작물 중복");
			return "duplicated";
		}
	}
}
