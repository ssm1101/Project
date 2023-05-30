package co.yedam.notice.command;

import java.io.IOException;
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

public class SellerQnaForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		MemberVO vo = new MemberVO();
		vo.setMbId(mbId);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int total = service.SellerQnaListTotalCnt(mbId);
		Criteria cri = new Criteria(pageNumInt,10);
		PageDTO dto = new PageDTO(cri,total);
		req.setAttribute("pageDTO", dto);
		
		List<NoticeVO> list = service.SellerQnaList(pageNumInt, vo);
		for(int i=0;i<list.size();i++) {
			NoticeVO vo1 = new NoticeVO();
			vo1.setPsId(list.get(i).getPsId());
			vo1.setPsDate(list.get(i).getPsDate().substring(0,10));
			vo1.setPsTitle(list.get(i).getPsTitle());
			vo1.setPsText(list.get(i).getPsText());
			vo1.setMbId(list.get(i).getMbId());
			list.set(i, vo1);
		}
		req.setAttribute("qnaList", list);
		
		return "seller/qna/sellerQna.tiles";
	}

}
