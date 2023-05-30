package co.yedam.product.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int prodId;
	private String prodStart;
	private String prodEnd;
	private int prodNum;
	private int prodPrice;
	private String prodText;
	private int tpId;
	private int payNum;
	private String mbId;
	
	private String tpName;
	private String tpImg;
	
	private int price;
	private int star;
}