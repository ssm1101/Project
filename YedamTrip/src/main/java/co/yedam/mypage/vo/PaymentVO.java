package co.yedam.mypage.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentVO {
	private int payId;
	private int prodId;
	private int payPrice;
	private int payNum;
	private int cpId;
	private String mbId;
	private String payName;
	private String payPhone;
	
	private int tpId;
	private String tpName;
	private String tpText;
	private String tpImg;
	private String tpArea;
	private String tpTheme;
	private String tpDate;
	private String count;
	private String price;
	private String star;
	
	private String prodStart;
	private String prodEnd;
	
	private String cpName;
	private String cpRate;
	
	private String mbName;
	private String TopPermiss;
}