package com.ohnong.app.stock.service;

import lombok.Data;

@Data
public class NeighborVO {
	/*
	 * 서브디비전
	 ITEM_CODE	VARCHAR2(30 BYTE) NOT NULL
	 NAME	VARCHAR2(100 BYTE)
	 MIDDLECATAGORI	VARCHAR2(30 BYTE) NOT NULL
	 USER_ID	VARCHAR2(10 BYTE) NOT NULL
	*/
	
	private int rn;
	private String name; // 장비 이름
	private String middlecatagori; // '대-농자재 중-농기계'
	
	private int no; // 시퀀스로(농기계 고유번호) -> 감추기
	private String itemCode; // 장비 코드(서브디비전) -> 감추기
	private String itemName; // 장비 이름
	private String rentalStatus; // 대여 상황
	private int rentalCount; // 대여 수량
	private int rentalPrice; // 대여비
	private String rentalPeriod; // 대여 기한
	private String manager; // 담당자
	private String phone; // 연락처
	private String rentalPlace; // 대여 장소
	private String userId; // 대여인
}
