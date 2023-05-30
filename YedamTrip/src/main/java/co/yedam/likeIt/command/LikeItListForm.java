package co.yedam.likeIt.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.likeIt.service.LikeItService;
import co.yedam.likeIt.service.impl.LikeItServiceImplMybatis;
import co.yedam.likeIt.vo.LikeItVO;

public class LikeItListForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		System.out.println(mbId);
		
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		LikeItVO vo = new LikeItVO();
		vo.setMbId(mbId);
		
		LikeItService service = new LikeItServiceImplMybatis();
		
		int total = service.likeItListPagingTotalCnt(mbId);
		System.out.println(total);
		Criteria cri = new Criteria(pageNumInt,5);
		PageDTO dto = new PageDTO(cri,total);
		req.setAttribute("pageDTO", dto);
		
		List<LikeItVO> list = service.likeItList(pageNumInt, vo);
		System.out.println(list);
		req.setAttribute("likeItList", list);
		
		return "user/mypage/likeList.tiles";
	}

}
