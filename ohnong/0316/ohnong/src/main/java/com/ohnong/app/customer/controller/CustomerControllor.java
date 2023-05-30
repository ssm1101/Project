package com.ohnong.app.customer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohnong.app.customer.service.CustomerService;
import com.ohnong.app.customer.service.CustomerVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerControllor {

	@Autowired
	CustomerService customerService;

	// 거래처 목록
	@GetMapping("/customerList")
	public String customerList(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		List<CustomerVO> list = customerService.getcustomerList(userId);
		System.out.println(list);
		model.addAttribute("customerList", list);
		return "content/customer/customerList";
	}

	// 거래처 정보
	@GetMapping("/accountList/{userId}/{businessName}")
	@ResponseBody
	public List<CustomerVO> getAccountList(@PathVariable("userId") String userId,
			@PathVariable("businessName") String businessName) {

		CustomerVO vo = new CustomerVO();

		vo.setUserId(userId);
		return customerService.getAccountList(userId, businessName);
	}

	// 거래처 수정
	@PostMapping("/customerList")
	public String customerList(CustomerVO customerVO, RedirectAttributes rttr) {
		if (customerService.customerMod(customerVO)) {
			System.out.println("변경 성공");
			rttr.addFlashAttribute("result", "success");
		} else {
			System.out.println("변경 실패");
			rttr.addFlashAttribute("result", "fail");
		}

		return "redirect:/customerList";
	}

	// 거래처 등록
	@PostMapping("/customerAdd")
	public String customerAdd(CustomerVO customerVO) {
		customerService.insertCustomer(customerVO);
		return "redirect:/customerList";
	}

	// 거래처 삭제
	@GetMapping("/customerDelete/{customerId}")
	@ResponseBody
	public String customerDelete(@PathVariable("customerId") int customerId) {
		int result = customerService.customerDelete(customerId);
		String message = "";
		if (result > 0) {
			message = "success";
		} else {
			message = "fail";
		}
		return message;
	}

	// 거래처 중복 확인
	@GetMapping("/checkCustomer")
	@ResponseBody
	public String checkCustomer(@RequestParam("customer") String customer, @RequestParam("userId") String userId) {
		int checkNum = customerService.checkCustomer(customer, userId);

		if (checkNum == 0) {
			System.out.println("등록 가능");
			return "available";
		} else {
			System.out.println("거래처 중복");
			return "duplicated";
		}
	}

}