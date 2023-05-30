package co.yedam.report.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PackageReportVO {
	private int tpId;
	private String ReportCon;
	
	private String tpName;
	private String tpText;
	private String tpImg;
	private String tpArea;
	private String tpTheme;
	private String tpDate;
	private String mbId;	
}
