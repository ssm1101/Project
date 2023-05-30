package com.ohnong.app.journal.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class JournalVO {
	
	/*PLAN_NO	NUMBER
	CROP_NO	NUMBER
	MONTH_PLAN	VARCHAR2(300 BYTE)
	START_DATE	DATE
	END_DATE	DATE
	USER_ID	VARCHAR2(10 BYTE)*/
	
	private int planNo;
	private int cropNo;
	private String monthPlan;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date endDate;
	private String userId;
	private String name;
	
	
}
