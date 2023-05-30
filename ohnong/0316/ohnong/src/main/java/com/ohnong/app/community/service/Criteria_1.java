package com.ohnong.app.community.service;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
@Component
public class Criteria_1 {
	private int pageNum;
	private int amount;
	
	private String type;
	
	private String keyword;
	
	private String category;
	
	private String col;
	
	//생성자로 무조건 실행되게 1페이지 10
	public Criteria_1(){ this(1,10); }
	
	public Criteria_1(int pageNum, int amount) {
		this.pageNum= pageNum;
		this.amount=amount;
		
		
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
							.queryParam("pageNum", pageNum)
							.queryParam("amount", amount);
		
		return builder.toUriString();
	}
	
	public String[] getTypeArr() {
		return type == null ? new String[]{} : type.split("");
	
	}
	
	public String[] getCategoryArr() {
		return category == null ? new String[]{} : category.split("");
	
	}
	

    @Override
    public String toString() {
    	return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type+ ",category="+ category +", col="+col+"]";
    }
	
}