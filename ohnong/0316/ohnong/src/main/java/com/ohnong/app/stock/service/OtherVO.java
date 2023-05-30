package com.ohnong.app.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OtherVO {
	private int stockNo;
	private int count;
	private int price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date registDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date reDate;
	private String userId;
	private String itemCode;
	private String oldItemCode;
	private String name;
	private String middleCatagori;
	private String mainCatagori;
	private int warehouseCode;
	private String warehouseName;
	private String explation;
}
