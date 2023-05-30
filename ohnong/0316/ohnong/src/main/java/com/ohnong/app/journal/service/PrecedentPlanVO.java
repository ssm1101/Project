package com.ohnong.app.journal.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PrecedentPlanVO {

	/*
	PLAN_NO	NUMBER
	CROP_NAME	VARCHAR2(200 BYTE)
	MONTH_PLAN	VARCHAR2(300 BYTE)
	START_DATE	DATE
	END_DATE	DATE
	MASTER_NAME	VARCHAR2(200 BYTE)
	*/
	
	private int planNo;
	private String cropName;
	private String monthPlan;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date endDate;
	private String masterName;
}
