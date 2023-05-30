package com.ohnong.app.stock.service;

import java.util.Date;

import lombok.Data;

@Data
public class CropVO {

	/*
	 * 서브디비전
	 ITEM_CODE	VARCHAR2(30 BYTE) NOT NULL
	 NAME	VARCHAR2(100 BYTE)
	 MIDDLECATAGORI	VARCHAR2(30 BYTE) NOT NULL
	 USER_ID	VARCHAR2(10 BYTE) NOT NULL
	 
	 * 크롭
	 CROP_NO	NUMBER NOT NULL
	 USER_ID	VARCHAR2(10 BYTE) NOT NULL
	 ITEM_CODE	VARCHAR2(30 BYTE) NOT NULL
	 REGIST_DATE	DATE
	 STATUS	NUMBER
	 */
	
	String rn;
	String itemCode;
	String name;
	String middlecatagori;
	String userId;
	
	int cropNo;
	Date registDate;
	int status;
}
