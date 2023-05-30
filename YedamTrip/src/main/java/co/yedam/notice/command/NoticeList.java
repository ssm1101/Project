package co.yedam.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt = Integer.parseInt(pageNum);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int total = service.noticeListPagingTotalCnt();
		Criteria cri = new Criteria(pageNumInt,10);
		PageDTO dto = new PageDTO(cri, total);
		req.setAttribute("pageDTO", dto);
		
		List<NoticeVO> list = service.noticeList(pageNumInt);
		for(int i=0;i<list.size();i++) {
			NoticeVO vo = new NoticeVO();
			vo.setPsId(list.get(i).getPsId());
			vo.setPsDate(list.get(i).getPsDate().substring(0,8));
			vo.setPsTitle(list.get(i).getPsTitle());
			vo.setPsText(list.get(i).getPsText());
			vo.setMbId(list.get(i).getMbId());
			list.set(i, vo);
		}
		req.setAttribute("noticeList", list);
		
		return "seller/notice/notice.tiles";
	}

}
