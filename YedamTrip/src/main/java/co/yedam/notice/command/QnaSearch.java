package co.yedam.notice.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class QnaSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int psId = Integer.parseInt(req.getParameter("psId"));
		String pageNum = req.getParameter("pageNum");
		HttpSession session = req.getSession(true);
		int mbGrade = (int) session.getAttribute("grade");
		
		System.out.println(psId);
		NoticeService service = new NoticeServiceImplMybatis();
		NoticeVO vo = service.noticeSearch(psId);
		
		req.setAttribute("vo", vo);
		req.setAttribute("pageNum", pageNum);
		System.out.println(vo);
		System.out.println(pageNum);
		
		if(mbGrade==1) {
			return "seller/qna/qnaSearch.tiles";
		}else if(mbGrade==2) {
			return "seller/qna/qnaAdminSearch.tiles";
		}
		
		return null;
	}

}
