package com.ohnong.app.notice.service;

import lombok.Data;  
import lombok.ToString;

@ToString
@Data
public class PageMakerDTO {
	
	 /* 시작 페이지 */
    private int startPage;
    
    /* 끝 페이지 */
    private int endPage;
    
    /* 이전 페이지, 다음 페이지 존재유무 */
    private boolean prev, next;
    
    /*전체 게시물 수*/
    private int total;
    
    /*전체 게시글 수*/
    private int realEnd;
    
    /* 페이징 수*/
    private int pageCount;
    
    /* 현재 페이지, 페이지당 게시물 표시수 정보 */
    private Criteria_2 cri;
    
    /* 생성자 */
    public PageMakerDTO(Criteria_2 cri, int pageCount,  int total) {
        
        this.cri = cri;
        this.total = total;
        this.pageCount= pageCount;
        
        /* 마지막 페이지 */
        this.endPage= (int)(Math.ceil(cri.getPageNum()*1.0/pageCount))*pageCount;
        /* 시작 페이지 */
        this.startPage = endPage - (pageCount-1);
        
        /* 전체 마지막 페이지 */
        int realEnd = (int)(Math.ceil(total*1.0 / cri.getAmount()));
        
        this.realEnd = realEnd;
        /* 전체 마지막 페이지(realend)가 화면에 보이는 마지막페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정 */
        if(realEnd < this.endPage) {
            this.endPage = realEnd == 0? 1 : realEnd;
        }
        
        /* 시작 페이지(startPage)값이 1보다 큰 경우 true */
        this.prev = this.startPage > 1;
        
        /* 마지막 페이지(endPage)값이 1보다 큰 경우 true */
        this.next = this.endPage < realEnd;
        
        
    }
    
    @Override
    public String toString() {
    	return "PageMakerDTO [realEnd="+realEnd+", startPage="+ startPage + ", endPage=" + endPage + ", prev=" + prev + " , next=" + next + ", total=" + total + ", cri=" + cri + ", pageCount = " + pageCount+" ]";
    }
    
    

}
