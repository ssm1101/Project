package com.ohnong.app.farm.service;

import java.util.List;

import lombok.Data;

@Data
public class FarmVO {
	
	/*
    user_id	VARCHAR2(10) NOT NULL,
	farm_name VARCHAR2(30) NOT NULL, --상호(농가명)
    farm_ceo VARCHAR2(10) NOT NULL, --대표명
    --농지취득서
	farm_addr VARCHAR2(30) NOT NULL, --지역:대구/경북/구/군
	plant_area NUMBER(10) NOT NULL, --재배면적
    MAINCATAGORI VARCHAR2(30) NOT NULL, --대분류
    MIDDLECATAGORI VARCHAR2(30) NOT NULL, --중분류
    SUBDIVISION VARCHAR2(30) NOT NULL, --소분류(대표작물)
    farm_detailaddr VARCHAR2(50), --상세주소
	homepage VARCHAR2(30), --홈페이지
	regist_num VARCHAR2(30), --사업자등록번호
	memo VARCHAR2(1000) --메모
	farm_state VARCHAR2(1) -- 농가 승인 요청 여부
	*/
	
	private String rn;
	private String userId;
	private String farmName;
	private String farmCeo;
	private String farmAddr;
	private String plantArea;
	private String maincatagori;
	private String middlecatagori;
	private String subdivision;
	private String farmDetailaddr;
	private String homepage;
	private String registNum;
	private String memo;
	private String farmState;
	private String filePath;

}
