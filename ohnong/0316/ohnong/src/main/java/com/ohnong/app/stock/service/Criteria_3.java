package com.ohnong.app.stock.service;

import lombok.Data;

@Data
public class Criteria_3 {
	//검색관련
	private String userId;
	private int warehouseCode;
	private String middleCatagori;
	private String name;
	private String startDate;
	private String endDate;
	
	private int pageNum;
	private int amount;
	
	public Criteria_3() {
		this.pageNum = 1;
		this.amount = 10;
	}
	
	public Criteria_3(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
