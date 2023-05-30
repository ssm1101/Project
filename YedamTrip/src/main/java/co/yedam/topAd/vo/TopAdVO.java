package co.yedam.topAd.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TopAdVO {
	private int tpId;
	private String topStart;
	private String topEnd;
	private String topPermiss;
	
	private String tpName;
	private String tpText;
	private String tpImg;
	private String tpArea;
	private String tpTheme;
	private String tpDate;
	
	private String mbId;
}
