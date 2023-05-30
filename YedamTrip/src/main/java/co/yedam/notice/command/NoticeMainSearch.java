package co.yedam.notice.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class NoticeMainSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int psId = Integer.parseInt(req.getParameter("psId"));
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		
		NoticeService service = new NoticeServiceImplMybatis();
		NoticeVO vo = service.noticeSearch(psId);
		
		req.setAttribute("vo", vo);
		req.setAttribute("pageNum", pageNum);
		
		return "user/notice/noticeSearch.tiles";
	}

}
