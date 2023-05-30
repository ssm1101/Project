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
import com.ohnong.app.stock.service.OtherVO;
import com.ohnong.app.stock.service.PageDTO_3;
import com.ohnong.app.stock.service.SeedService;
import com.ohnong.app.stock.service.WarehouseVO;

//seungmin 종묘관리
@Controller
public class SeedController {
	
	@Autowired
	SeedService seedService;
	
	@Autowired
	HarvestService harvestService;
	
	//종묘리스트
	@GetMapping("/seedList")
	public String getSeedList(@ModelAttribute("cri") Criteria_3 cri, Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		cri.setUserId(id);
		System.out.println(cri);
		List<OtherVO> seedList = seedService.getSeedListWithPaging(cri);
		int totalCount = seedService.getTotalCount(cri);
		List<WarehouseVO> warehouseList = harvestService.getWarehouseList(id);
		
		model.addAttribute("pageInfo", new PageDTO_3(cri, totalCount));
		model.addAttribute("seedList", seedList);
		model.addAttribute("warehouseList", warehouseList);
		
		return "content/stock/seedList";
	}
	
	//종묘,농약,비료 수정
	@PostMapping("/seedUpdate")
	@ResponseBody
	public String seedUpdate(OtherVO vo, RedirectAttributes rttr, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		int result = seedService.seedUpdate(vo);
		System.out.println(result);
		
		return "true";
	}
	
	//종묘,농약,비료 삭제 : 소분류,지출,종묘.농약.비료 삭제
	@GetMapping("/seedDelete/{stockNo}/{itemCode}")
	@ResponseBody
	public String seedDelete(@PathVariable("stockNo") int stockNo,
							 @PathVariable("itemCode") String itemCode) {
		OtherVO vo = new OtherVO();
		vo.setStockNo(stockNo);
		vo.setItemCode(itemCode);
		seedService.seedDelete(vo);
		
		return "success";
	}
	
	//종묘등록 : 소분류,지츨,종묘 등록
	@PostMapping("/seedInsert")
	public String seedInsert(OtherVO vo, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		vo.setUserId(id);
		List<OtherVO> list = seedService.seedListWithMiddle(vo);
		if(list.isEmpty()) {
			seedService.seedInsert(vo);
		} else {
			seedService.seednotInsert(vo);
		}
		
		return "redirect:seedList";
	}
	
	//중복코드등록 체크
	@GetMapping("/findSubdivision/{name}/{middle}")
	@ResponseBody
	public String findSubdivision(@PathVariable("name") String name,
								  @PathVariable("middle") String middle,
								  HttpSession session) {
		String id = (String)session.getAttribute("userId");
		OtherVO vo = new OtherVO();
		vo.setUserId(id);
		vo.setName(name);
		vo.setMiddleCatagori(middle);
		vo = seedService.findSubdivision(vo);
		System.out.println(vo);
		String code;
		if(vo == null) {
			code = "notFound";
		} else {
			code = vo.getName();
		}
		return code;
	}
	
	@GetMapping("/seedListWithMiddle/{value}")
	@ResponseBody
	public List<OtherVO> seedListWithMiddle(@PathVariable("value") String middleCatagori, HttpSession session){
		String id = (String)session.getAttribute("userId");
		OtherVO vo = new OtherVO();
		vo.setUserId(id);
		vo.setMiddleCatagori(middleCatagori);
		List<OtherVO> list = seedService.seedListWithMiddle(vo);
		
		return list;
	}
	
	@GetMapping("/getCount/{name}")
	@ResponseBody
	public OtherVO getCount(@PathVariable("name") String name, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		OtherVO vo = new OtherVO();
		vo.setUserId(id);
		vo.setName(name);
		
		return seedService.getCount(vo);
	}
}
