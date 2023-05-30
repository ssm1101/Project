package co.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchVO {
	private String searchCondition;
	private String keyword;
	private String prodId;
}
