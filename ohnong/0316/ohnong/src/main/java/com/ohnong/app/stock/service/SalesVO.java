package com.ohnong.app.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SalesVO {
	private int no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date currentDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date today;
	private String middleCatagori;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+9")
	private Date thisDay;
	private String name;
	private int amount;
	private int count;
	private int unitPrice;
	private int total;
	private String customer;
	private String userId;
	private int cropNo;
}
