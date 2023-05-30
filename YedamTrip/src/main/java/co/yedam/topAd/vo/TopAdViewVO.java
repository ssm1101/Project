package co.yedam.topAd.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class TopAdViewVO {
	//top_start, top_end, tp_name, tp_text, tp_img, tp_area, tp_theme, tp_date
	private String topStart;
	private String topEnd;
	private String tpId;
	private String tpName;
	private String tpText;
	private String tpImg;
	private String tpArea;
	private String tpTheme;
	private String tpDate;
	
	private String mbId;
	
}
