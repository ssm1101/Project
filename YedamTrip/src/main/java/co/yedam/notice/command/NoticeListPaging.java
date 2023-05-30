package co.yedam.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class NoticeListPaging implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {

		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
//		pageNum = pageNum == null ? "1" : pageNum;
//		int pageNumInt=Integer.parseInt(pageNum);
//		System.out.println(pageNum);
		
		Criteria cri = new Criteria(pageNum,10);
		System.out.println(pageNum);
		
		NoticeService service = new NoticeServiceImplMybatis();
		List<NoticeVO> list = service.noticeList(pageNum);
		
		System.out.println(list);
		
//		Criteria cri=new Criteria(pageNumInt,10);
//		PageDTO dto=new PageDTO(cri, total);
//		req.setAttribute("pageDTO", dto);
		
		for(int i=0;i<list.size();i++) {
			NoticeVO vo = new NoticeVO();
			vo.setPsId(list.get(i).getPsId());
			vo.setPsDate(list.get(i).getPsDate().substring(0,10));
			vo.setPsTitle(list.get(i).getPsTitle());
			vo.setPsText(list.get(i).getPsText());
			vo.setMbId(list.get(i).getMbId());
			list.set(i, vo);
		}
		
		System.out.println(list);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(list);
			return json + ".ajax";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	return null;
	}

}
