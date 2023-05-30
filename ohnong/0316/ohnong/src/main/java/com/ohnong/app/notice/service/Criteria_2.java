package com.ohnong.app.notice.service;

import lombok.Data;

@Data
public class Criteria_2 {
	
	/* 현재 페이지 */
    private int pageNum;
    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;
    
    /* 검색 키워드 */
    private String keyword;
    
    /* 검색 타입 */
	private String type;

    
    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
    public Criteria_2() {
        this(1,10);
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public Criteria_2(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    /* 검색 타입 배열 변환 
	private String[] typeArr;

    public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}*/
    
    public String[] getTypeArr() {
    	
    	return type == null ? new String[]{} : type.split("");
		
	}
    
    @Override
    public String toString() {
    	return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type+ "]";
    }
    
}
