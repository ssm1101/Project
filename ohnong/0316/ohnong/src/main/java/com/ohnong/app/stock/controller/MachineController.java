package com.ohnong.app.stock.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.ohnong.app.stock.service.MachineService;
import com.ohnong.app.stock.service.MachineVO;
import com.ohnong.app.stock.service.NeighborVO;
import com.ohnong.app.stock.service.PageDTO_3;
import com.ohnong.app.stock.service.WarehouseVO;

//seungmin 농기계관리
@Controller
public class MachineController {
	
	@Autowired
	MachineService machineService;
	
	@Autowired
	HarvestService harvestService;
	
	//농기계리스트
	@GetMapping("/machineList")
	public String getMachineList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		List<MachineVO> machineList = machineService.getMachineListWithPaging(cri);
		int totalCount = machineService.getTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		List<NeighborVO> neighborList = machineService.getneighborListWithPaging(cri);
		List<NeighborVO> submitMachineList = machineService.submitMachineList(id);
		
		model.addAttribute("submitMachine", submitMachineList);
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("machineList", machineList);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("neighborList", neighborList);
		
		return "content/stock/machineList";
	}
	
	//농기계수정
	@PostMapping("/machineUpdate")
	@ResponseBody
	public String machineUpdate(MachineVO vo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		int result = machineService.machineUpdate(vo);
		System.out.println(result);
		
		return "true";
	}
	
	//농기계대여삭제 : 소분류,지출,농기계대여 삭제
	@GetMapping("/machineDelete/{itemCode}")
	@ResponseBody
	public String machineDelete(@PathVariable("itemCode") String itemCode) {
		machineService.machineDelete(itemCode);
		
		return "success";
	}
	
	//농기계대여반납 : 농기계대여삭제
	@GetMapping("/machineReturn/{itemCode}")
	@ResponseBody
	public String machineReturn(@PathVariable("itemCode") String itemCode) {
		machineService.machineReturn(itemCode);
		
		return "success";
	}
	
	//농기계등록
	@PostMapping("/machineInsert")
	public String machineInsert(MachineVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		List<MachineVO> list = machineService.machineListWithMiddle(vo);
		System.out.println(list);
		System.out.println(vo);
		
		if(list.isEmpty()) {
			machineService.machineInsert(vo);
		} else if(list.get(0).getRentalDate() == null) {
			vo.setItemCode(list.get(0).getItemCode());
			machineService.machineInsertnotSubdivision(vo);
		} else {
			vo.setItemCode(list.get(0).getItemCode());
			machineService.machinenotInsert(vo);
		}
		
		return "redirect:machineList";
	}
	
	//대여신청
	@PostMapping("/neighborUpdate")
	@ResponseBody
	public String neighborUpdate(NeighborVO nvo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		System.out.println(nvo);
		nvo.setUserId(id);
		machineService.neighborStatusUpdate(nvo);
		
		return "success";
	}
	
	//대여취소
	@PostMapping("/neighborDisUpdate")
	@ResponseBody
	public String neighborStatusDisUpdate(NeighborVO nvo) {
		machineService.neighborStatusDisUpdate(nvo);
		
		return "success";
	}
	
	//등록된 농기계 리스트
	@GetMapping("/machineListWithMiddle/{value}")
	@ResponseBody
	public List<MachineVO> machineListWithMiddle(@PathVariable("value") String middleCatagori, HttpSession session){
		String id = (String)session.getAttribute("userId");
		MachineVO vo = new MachineVO();
		vo.setUserId(id);
		vo.setMiddleCatagori(middleCatagori);
		List<MachineVO> list = machineService.machineListWithMiddle(vo);
		
		return list;
	}
	
	//선택농기계 정보
	@GetMapping("/getMachineCount/{name}")
	@ResponseBody
	public MachineVO getCount(@PathVariable("name")String name, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		MachineVO vo = new MachineVO();
		vo.setUserId(id);
		vo.setName(name);
		
		return machineService.getCount(vo);
	}
	
	// #관리자용
	// 우리 동네 농기계 - 조회
	@GetMapping("/neighborhoodRentalList")
	public String neighborhoodRentalList(Model model) {
		model.addAttribute("rentalList", machineService.neighborhoodRentalList());
		return "content/stock/neighborhoodRentalList";
	}
	
	// 우리 동네 농기계 - 승인
	// 네이벌 - 업데이트 // 머신 - 인설트
	@PostMapping("/changeState")
	@ResponseBody
	public String changeState(NeighborVO nVO) {
		
		System.out.println("결과: " + nVO);
		machineService.changeState(nVO);
		
		MachineVO mvo = new MachineVO();
		mvo.setUserId(nVO.getUserId());
		mvo.setItemCode(nVO.getItemCode());
		mvo.setName(nVO.getItemName());
		mvo.setRentalPlace(nVO.getRentalPlace());
		mvo.setCount(nVO.getRentalCount());
		mvo.setRentalPrice(nVO.getRentalPrice());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = new Date(System.currentTimeMillis()); // 현재 날짜

		//String rentalDate = formatter.format(startDate); // rentalDate -> 대여일
		mvo.setStartDate(startDate); 
		
		Calendar cal = Calendar.getInstance(); // 날짜 계산
		cal.setTime(startDate);
		cal.add(Calendar.DATE, Integer.parseInt(nVO.getRentalPeriod()));
		
		//String returnDate = formatter.format(cal.getTime()); // returnDate -> 반납일
		mvo.setEndDate(cal.getTime()); 
		
		machineService.changeState2(mvo);
		
		return "redirect:neighborhoodRentalList";
	}
	
	
	// 우리 동네 농기계 - 수정
	// 독립적(대여수량, 대여기한, 대여장소, 담당자, 연락처)
	@PostMapping("/neighborhoodRentalList")
	public String rentalMod(NeighborVO nVO, RedirectAttributes rttr) {
		if (machineService.rentalMod(nVO)) {
			System.out.println("변경 성공");
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("변경 실패");
			rttr.addFlashAttribute("result", "fail");
		}
		
		return "redirect:/neighborhoodRentalList";
	}
	
	// 우리 동네 농기계 - 삭제
	// 진짜 삭제(no로)
	@GetMapping("/rentalDelete/{no}")
	@ResponseBody
	public String rentalDelete(@PathVariable("no") int no) {
		int result = machineService.rentalDelete(no);
		String message = "";
		if (result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

	// 우리 동네 농기계 - 등록
	// 서브디비전 -> 네이벌
	@PostMapping("/rentalAdd")
	public String rentalAdd(NeighborVO nVO) {
		machineService.insertRental(nVO);
		return "redirect:/neighborhoodRentalList";
	}
	
}
