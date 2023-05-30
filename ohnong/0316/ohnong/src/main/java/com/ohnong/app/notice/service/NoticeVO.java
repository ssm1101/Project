package com.ohnong.app.notice.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class NoticeVO {
//	NOTICE_NO       NOT NULL NUMBER(10)     
//	NOTICE_TITLE    NOT NULL VARCHAR2(1000) 
//	NOTICE_CONTENT  NOT NULL VARCHAR2(2000) 
//	NOTICE_WRITER            VARCHAR2(100)  
//	REGDATE                  DATE           
//	UPDATEDATED              DATE           
//	HIT_CNT                  NUMBER(10)     
//	NOTICE_CATEGORY NOT NULL VARCHAR2(100)  
	/**
	 * 
	 * 
CREATE SEQUENCE seq_notice;
CREATE table notice(
NOTICE_NO          NUMBER(10),     
NOTICE_TITLE       VARCHAR2(1000), 
NOTICE_CONTENT     VARCHAR2(2000), 
NOTICE_WRITER      VARCHAR2(100),  
REGDATE            DATE     DEFAULT sysdate  ,    
UPDATEDATE         DATE     DEFAULT sysdate ,     
HIT_CNT            NUMBER(10)  DEFAULT 0 ,  
NOTICE_CATEGORY    VARCHAR2(100)  ,
DELETED            NUMBER(10) DEFAULT 0  
);
	 * 
	 * */
	
	int rn;
	int noticeNo;
	String noticeTitle;
	String noticeContent;
	String noticeWriter;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date regDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date updateDate;
	
	int hitCnt;
	
	String noticeCategory;
	int Deleted;
	
	
	@Override
	public String toString() {
		return "NoticeVO [ rn="+ rn +"noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeWriter=" + noticeWriter + ", regDate="
				+ regDate + ", updateDate=" + updateDate + ",noticeCategory="+ noticeCategory + ",deleted =" + Deleted +"]";
	}

}
