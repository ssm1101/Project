package co.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria extends SearchVO{
	private int pageNum; //현재페이지
	private int amount; //한페이지당 보여질 건수

	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}
	
	public Criteria(int pageNum , int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public void setSearchCondition(String searchCondition) {
		// TODO Auto-generated method stub
		
	}

	public void setKeyword(String keyword) {
		// TODO Auto-generated method stub
		
	}
	
}
