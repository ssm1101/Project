package com.ohnong.app.community.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PageDTO_1 {

	private int pageCount;
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev, next;
	private int total;
	private Criteria_1 criteria;
	
	public PageDTO_1() {};
	
	public PageDTO_1(int total, int pageCount, Criteria_1 criteria) {
	
			this.total=total;
			this.criteria=criteria;
			this.pageCount= pageCount;
			
			this.endPage= (int)(Math.ceil(criteria.getPageNum()*1.0/pageCount))*pageCount;
			this.startPage = endPage - (pageCount-1);
			
			realEnd = (int)(Math.ceil(total*1.0 / criteria.getAmount()));
			
		
			if(endPage > realEnd) {
				endPage = realEnd == 0? 1 : realEnd;
			}
			
			prev = startPage >1;
			next = endPage < realEnd;
	}
	
}
