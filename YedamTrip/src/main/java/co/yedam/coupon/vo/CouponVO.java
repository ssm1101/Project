package co.yedam.coupon.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponVO {
	private int cpId;
	private String cpName;	
	private int cpRate;
	private String cpPublisher;
	private String cpExpire;
	
	private int ucpId;
	private String mbId;
	private String cpStatus;
}
