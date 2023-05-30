package com.ohnong.app.farm.service;

import lombok.Data;

@Data
public class FarmAttachVO {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	
	private String farmName;
}
