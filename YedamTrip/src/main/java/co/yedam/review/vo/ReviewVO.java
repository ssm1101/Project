package co.yedam.review.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
	
	public int reviewId;
	public String reviewCon;
	public int reviewStar;
	public int tpId;
	public String reviewDate;
	public String mbId;
}
