package com.ohnong.app.journal.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FarmJournalVO {
		
	
	private int journalNO;
	private String journalTitle;
	private String journalCon;
	private String userId;
	private String name;
	private String filePath;
	private String weather;
	private String temperatures;
	private String wind;
	private String precipitation;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date planDate;
	
}
