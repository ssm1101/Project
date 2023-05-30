package co.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev,next;
	
	//페이징하려면 토탈데이터를 알아야 가능
	private int total;
	
	//현재페이지 12,한페이지당 건수 
	//이건 빈번하게 사용해서 클래스를 따로
	private Criteria cri;
	
	public PageDTO(Criteria cri , int total) {
		this.cri = cri;
		this.total = total;
		
		//12p => 끝페이지 20p 
							//올림하겠다(소수점)		1		/	5							5
								//        math.ceil ( 12/10.0 )*10 => 20p
		this.endPage = (int) (Math.ceil(cri.getPageNum()/(cri.getAmount()*1.0)))*cri.getAmount();
		this.startPage = this.endPage - (cri.getAmount()-1);
		int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage<realEnd;
	}
	
	
}
