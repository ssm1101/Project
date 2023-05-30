package com.ohnong.app.cost.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CostVO {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date today;
	private String middleCategori;
	private String itemCode;
	private String detail;
	private int cash;
	private int total;
	private String userId;
	private String mainCategori;
	private String explation;
	private String startDate;
	private String endDate;
}
