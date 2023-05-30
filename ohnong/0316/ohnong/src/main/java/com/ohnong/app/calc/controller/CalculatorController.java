package com.ohnong.app.calc.controller;




import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CalculatorController {
	
	@GetMapping("/calculationSelect")
	public String CalculatorSelecte() {
		return "content/calculation/calculationSelect";
	};
	
	@GetMapping("/calculation01")
	public String calculation01() {
		return "content/calculation/calculation01"; 
	};
	
	
	@PostMapping("/calculationResult01")
	public String calculationResult01(Model model,HttpServletRequest request) {
		
		String amount = request.getParameter("amount");
		String cropName = request.getParameter("cropName");
		String cropPrice1 = request.getParameter("cropPrice1");
		String cropPrice2 = request.getParameter("cropPrice2");
		
		String amounts = amount.replaceAll(",","");
		
		model.addAttribute("amount",amount);
		model.addAttribute("cropName",cropName);
		model.addAttribute("cropPrice1",cropPrice1);
		model.addAttribute("cropPrice2",cropPrice2);
		
		double result = ((Integer.parseInt(amounts)*12)/(1-0.5733158411791957));
		result = (Math.round(result)*1);
		String calcResult = String.format("%.0f",result);
		System.out.println(calcResult);
		String calcResultInfo = calcResult.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		double management = (Integer.parseInt(calcResult)-(Integer.parseInt(amounts)*12));
		
		management = (Math.round(management)*1);
		String managementResult = String.format("%.0f",management);
		String managementInfo = managementResult.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
		
		double sqft = (Integer.parseInt(calcResult) / Integer.parseInt(cropPrice2))*0.33;
		System.out.println(sqft+"!!");
		double sqftResult = (int) (sqft*10);
		
		model.addAttribute("managementResult",managementResult);
		model.addAttribute("result",calcResultInfo);
		model.addAttribute("result2",managementInfo);
		model.addAttribute("sqftResult",sqftResult);
		return "content/calculation/calculationResult01"; 
	};
	
	@GetMapping("/calculation02")
	public String calculation02() {
		return "content/calculation/calculation02"; 
	};
	
	@PostMapping("/calculationResult02")
	public String calculationResult02(Model model,HttpServletRequest request) {
		
		String amount = request.getParameter("amount");
		String cropName = request.getParameter("cropName");
		String cropPrice1 = request.getParameter("cropPrice1");
		String cropPrice2 = request.getParameter("cropPrice2");
		
		System.out.println(amount);
		System.out.println(cropName);
		System.out.println(cropPrice1);
		System.out.println(cropPrice2);
		
		model.addAttribute("amount",amount);
		model.addAttribute("cropName",cropName);
		model.addAttribute("cropPrice1",cropPrice1);
		model.addAttribute("cropPrice2",cropPrice2);
		
		
		
		return "content/calculation/calculationResult02";
	}
	
}
