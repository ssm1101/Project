package co.yedam.common;

import co.yedam.login.memberVO.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberPageInfo extends MemberVO {
	private int pageNum; //현재페이지
	private int amount; //한페이지당 보여질 건수.
	
	public MemberPageInfo() {
		this.pageNum=1;
		this.amount=10;
	}
	
	public MemberPageInfo(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
}
