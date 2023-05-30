package com.ohnong.app.community.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReportVO {
	
	
	int boardBno; // 글번호
	int reportBno; //신고글번호
	String reportType; //신고유형
	String reportContent; //신고내용
	String userId; //유저아이디
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	Date reportDate; //신고날짜
	
//	CREATE TABLE report (
//			  board_bno number ,
//			  report_bno NUMBER(10),
//			  report_type VARCHAR2(50),
//			  report_content VARCHAR2(500),
//			  user_id VARCHAR2(50),
//			  report_date DATE
//			);

	

	

}
