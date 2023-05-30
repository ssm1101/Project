package co.yedam.notice.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class Paging implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String pageNum=req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int total=service.noticeListPagingTotalCnt();
		
		System.out.println(total);
		
		Criteria cri=new Criteria(pageNumInt,10);
		PageDTO dto=new PageDTO(cri, total);
		
		System.out.println(dto);
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(dto);
			return json + ".ajax";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
