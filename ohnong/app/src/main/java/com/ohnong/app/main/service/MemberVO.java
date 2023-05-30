package com.ohnong.app.main.service;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	/*
	user_id	VARCHAR2(10) NOT NULL,
	user_pw	VARCHAR2(30) NOT NULL,
	user_name VARCHAR2(15) NOT NULL,
	birth VARCHAR2(8) NOT NULL,
	user_email VARCHAR2(30)	NOT NULL,
	user_addr VARCHAR2(100)	NOT NULL,
	user_tel VARCHAR2(13) NOT NULL,
	grade VARCHAR2(1) DEFAULT 'U',
	farmState VARCHAR2(1) DEFAULT 'N',
	temporary_pw VARCHAR2(10),
	UUID VARCHAR2(100),
    session_id VARCHAR2(80),
	limit_time date
	*/
	
	String userId;
	String userPw;
	String userName;
	String birth;
	String userEmail;
	String userAddr;
	String userTel;
	String grade;
	String farmState;
	String Uuid;
	String sessionId;
	Date limitTime;

}
