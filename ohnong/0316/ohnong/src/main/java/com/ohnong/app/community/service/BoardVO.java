package com.ohnong.app.community.service;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	
	int rownum; //정렬을위한 로우넘
	
	int boardBno; //진짜 글번호
	String boardTitle;
	String boardContent;
	Date boardRegdate;    //default sysdate
	Date boardUploaddate; //default sysdate
	int boardLike;		  //default 0	
	int boardHitcount;    //default sysdate
	String boardCategory;
	String userId;
	String uuid;
	int exist; 			//삭제요청유무 기본 0,삭제요청시1
	int noshow; 		//문의공개유무 기본 0, 비공개 1
	int reportCount;
	int adminrep; //관리자 댓글 갯수 기본 0
	
	//글등록시 첨부파일
	//private List<AttachVO> attachList;
	
}

//BOARD_BNO	NUMBER
//BOARD_TITLE	VARCHAR2(50 BYTE)
//BOARD_CONTENT	VARCHAR2(1000 BYTE)
//BOARD_REGDATE	DATE
//BOARD_UPLOADDATE	DATE
//BOARD_LIKE	NUMBER
//BOARD_HITCOUNT	NUMBER
//BOARD_CATEGORY	VARCHAR2(50 BYTE)
//USER_ID	VARCHAR2(10 BYTE)
//UUID	VARCHAR2(100 BYTE)
//EXIST	NUMBER(1,0)
//NOSHOW	NUMBER(1,0)
