package com.ohnong.app.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WarehouseVO {
	String rn;
	
	private int warehouseCode;
	private String warehouseName;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "GMT+9")
	private Date registDate;
	private String userId;
	private int status;
}
