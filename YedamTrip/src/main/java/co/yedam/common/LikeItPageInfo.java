package co.yedam.common;

import co.yedam.likeIt.vo.LikeItVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeItPageInfo extends LikeItVO {
	private int pageNum;
	private int amount;
	
	public LikeItPageInfo() {
		this.pageNum=1;
		this.amount=10;
	}
	
	public LikeItPageInfo(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
}
