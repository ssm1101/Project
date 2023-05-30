package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class NoticeSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int psId = Integer.parseInt(req.getParameter("psId"));
		String pageNum = req.getParameter("pageNum");
		
		System.out.println(psId);
		NoticeService service = new NoticeServiceImplMybatis();
		NoticeVO vo = service.noticeSearch(psId);
		
		req.setAttribute("vo", vo);
		req.setAttribute("pageNum", pageNum);
		System.out.println(vo);
		System.out.println(pageNum);
		
		return "seller/notice/noticeSearch.tiles";
	}

}
