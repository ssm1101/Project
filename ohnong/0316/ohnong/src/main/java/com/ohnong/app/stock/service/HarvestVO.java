package com.ohnong.app.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HarvestVO {
	private int harvestNo;
	private int defectiveNo;
	private int count;
	private int defectiveCount;
	private String defect;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date registeDate;
	private String userId;
	private int cropNo;
	private int warehouseCode;
	private String warehouseName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date reDate;
	
	private String itemCode;
	private String oldItemCode;
	private String middleCatagori;
	private String name;
	private int status;
	private String explation;
}
