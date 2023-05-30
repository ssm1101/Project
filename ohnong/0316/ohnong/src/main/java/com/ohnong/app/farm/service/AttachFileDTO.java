package com.ohnong.app.farm.service;

import lombok.Data;

@Data
public class AttachFileDTO {

	// 업로드된 정보를 ajax로 반환
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
}
