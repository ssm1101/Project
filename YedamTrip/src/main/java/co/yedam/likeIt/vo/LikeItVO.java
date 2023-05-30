package co.yedam.likeIt.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeItVO {
	private int tpId;
	private String mbId;
	
	private String tpName;
	private String tpText;
	private String tpImg;
	private String tpArea;
	private String tpTheme;
	private String tpDate;
}
