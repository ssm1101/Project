package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;


public class UPaging implements Command{

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String pageNum=req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		MemberService service = new MemberServiceImplMybatis();
		int total=service.sellerListPagingTotalCnt();
		
		Criteria cri=new Criteria(pageNumInt,10);
		PageDTO dto=new PageDTO(cri, total);
		
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
