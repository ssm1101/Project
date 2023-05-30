package co.yedam.login.memberVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String mbId;
	private String mbPw;
	private String mbName;
	private String mbPhone;
	private String mbEmail;
	private String bsCode;
	private int mbGrade;
	private int sellPermiss;
}