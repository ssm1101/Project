package com.ohnong.app.cost.service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO_4 {
	
	private int startPage;
	
	private int endPage;
	
	private boolean prev, next;

	private int total; // 전체건수.

    private int readEnd;

	private Criteria_4 cri; // 매개값으로 pageNum, amount

	public PageDTO_4(Criteria_4 cri, int total) {
		 this.cri = cri;
	        this.total = total;
	        
	        /* 마지막 페이지 */
	        this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
	        /* 시작 페이지 */
	        this.startPage = this.endPage - 9;
	        
	        /* 전체 마지막 페이지 */
	        int realEnd = (int)(Math.ceil(total * 1.0/cri.getAmount()));
	        
	        this.readEnd = realEnd;
	        /* 전체 마지막 페이지(realend)가 화면에 보이는 마지막페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정 */
	        if(realEnd < this.endPage) {
	            this.endPage = realEnd;
	        }
	        
	        /* 시작 페이지(startPage)값이 1보다 큰 경우 true */
	        this.prev = this.startPage > 1;
	        
	        /* 마지막 페이지(endPage)값이 1보다 큰 경우 true */
	        this.next = this.endPage < realEnd;
	        
	}

    @Override
    public String toString() {
    	return "PageMakerDTO [readEnd="+readEnd+"startPage="+ startPage + ", endPage=" + endPage + ", prev=" + prev + " , next=" + next + ", total=" + total + ", cri=" + cri +" ]";
    }
    
}
