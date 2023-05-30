package com.ohnong.app.main.service;

import java.util.Date;

import lombok.Data;

@Data
public class CropVO {

	int cropNo;
	String userId;
	String itemCode;
	Date registDate;
}
