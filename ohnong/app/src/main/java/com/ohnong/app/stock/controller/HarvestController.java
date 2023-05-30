package com.ohnong.app.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ohnong.app.stock.service.HarvestService;


@Controller
public class HarvestController {
	
	@Autowired
	HarvestService harvestService;
	
	@GetMapping("/harvestList")
	public String harvestList() {
		return "content/stock/harvestList";
	}
	
}
