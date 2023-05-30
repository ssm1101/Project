package com.ohnong.app.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EquipmentVO {
	private int equipmentNo;
	private int count;
	private int equipmentPrice;
	private String equipmentStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date registDate;
	private String userId;
	private String itemCode;
	private String name;
	private int warehouseCode;
	private String warehouseName;
	private String middleCatagori;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date reDate;
	private String mainCatagori;
	private String explation;
}
