package co.yedam.notice.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	
	private int psId;
	private String psTitle;
	private String psDate;
	private String psText;
	private String psCategory;
	private String mbId;
	private int psKind;
	
	private String sellerId;
	
}
