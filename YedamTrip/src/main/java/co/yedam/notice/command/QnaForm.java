package co.yedam.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class QnaForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		System.out.println(mbId);
		
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		MemberVO vo = new MemberVO();
		vo.setMbId(mbId);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int total = service.qnaListPagingTotalCnt(mbId);
		System.out.println(total);
		Criteria cri = new Criteria(pageNumInt,3);
		PageDTO dto = new PageDTO(cri,total);
		req.setAttribute("pageDTO", dto);
		
		List<NoticeVO> list = service.qnaList(pageNumInt, vo);
		req.setAttribute("qnaList", list);
		
		return "user/qna/qna.tiles";
	}

}
