package co.yedam.trip.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TripVO {
	public int tpId;
	public String tpName;
	public String tpText;
	public String tpImg;
	public String tpArea;
	public String tpTheme;
	public String tpDate;
	public String mbId;
	
	private int price;
	private int star;
	
	private String heart;
}