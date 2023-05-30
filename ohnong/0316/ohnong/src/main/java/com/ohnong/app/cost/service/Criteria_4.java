package com.ohnong.app.cost.service;

import lombok.Data;

@Data
public class Criteria_4 {
	//검색관련
	private String userId;
	private String middleCategori;
	private String middleCatagori;
	private String startDate;
	private String endDate;
	private String total;
	private String name;
	
	private int pageNum;
	private int amount;
	
	public Criteria_4() {
		this.pageNum = 1;
		this.amount = 10;
	}
	
	public Criteria_4(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
