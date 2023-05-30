package com.ohnong.app.customer.service;

import lombok.Data;

@Data
public class CustomerVO {

	/*
	customer_id	VARCHAR2(10) NOT NULL,    거래처 코드
	customer VARCHAR2(30) NOT NULL,    상호명
	customer_name VARCHAR2(5) NOT NULL,    대표명(이름)
	customer_tel VARCHAR2(13) NOT NULL,    연락처
	customer_addr VARCHAR2(30),    주소
	account_name VARCHAR2(10),    예금주
	bank_name VARCHAR2(30),    은행명
	account_num VARCHAR2(30),    계좌번호
	memo VARCHAR2(300),    메모
	regist_num VARCHAR2(30),    사업자등록번호
	user_id	VARCHAR2(10),    NOT NULL
	MAINCATAGORI VARCHAR2(30 BYTE)
	MIDDLECATAGORI VARCHAR2(30 BYTE)
	SUBDIVISION NOT NULL VARCHAR2(30 BYTE) NOT NULL,    대표 품목
	manager_name VARCHAR2(5) NOT NULL,     담당자(이름)
	*/
	
	String rn;
	String customerId;
	String customer;
	String customerName;
	String customerTel;
	String customerAddr;
	String accountName;
	String bankName;
	String accountNum;
	String memo;
	String registNum;
	String userId;
	String maincatagori;
	String middlecatagori;
	String subdivision;
	String managerName;
}
