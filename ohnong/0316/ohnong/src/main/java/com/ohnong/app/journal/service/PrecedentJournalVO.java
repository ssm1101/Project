package com.ohnong.app.journal.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PrecedentJournalVO {
	
	/*
	PRECEDENJOURANL_NO	NUMBER
	PRECEDENJOURANL_TITLE	VARCHAR2(2000 BYTE)
	PRECEDENJOURANL_CON	VARCHAR2(4000 BYTE)
	MASTER_NAME	VARCHAR2(100 BYTE)
	NAME	VARCHAR2(100 BYTE)
	IMG_NAME	VARCHAR2(500 BYTE)
	WEATHER	VARCHAR2(200 BYTE)
	TEMPERATURES	VARCHAR2(200 BYTE)
	WIND	VARCHAR2(200 BYTE)
	PRECIPITATION	VARCHAR2(200 BYTE)
	PLAN_DATE	DATE
	*/
	
	private int precedenjouranlNo;
	private String precedenjouranlTitle;
	private String precedenjouranlCon;
	private String masterName;
	private String name;
	private String imgName;
	private String weather;
	private String temperatures;
	private String wind;
	private String precipitation;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date planDate;
	
}
