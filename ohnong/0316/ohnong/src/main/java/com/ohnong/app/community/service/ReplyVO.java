package com.ohnong.app.community.service;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	int rownum;
	
	int replyboardBno;
	String replyboardContent;
	Date replyboardRegdate;
	Date replyboardUploaddate;
	String userId;
	int boardBno;
	
	
}

//REPLYBOARD_BNO			NUMBER
//REPLYBOARD_CONTENT		VARCHAR2(500 BYTE)
//REPLYBOARD_REGDATE		DATE
//REPLYBOARD_UPLOADDATE		DATE
//USER_ID					VARCHAR2(10 BYTE)
//BOARD_BNO					NUMBER