package co.yedam.report.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewReportVO {
	
	public int reviewId;
	private String ReportCon;
	public String reviewCon;
	public int reviewStar;
	public int tpId;
	public String reviewDate;
	public String mbId;
	
}
