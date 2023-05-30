package co.yedam.topAd.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;
import co.yedam.topAd.vo.TopAdVO;

public class TopdisplayList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		
		SearchVO svo =new SearchVO();
		
		svo.setSearchCondition(searchCondition);
		svo.setKeyword(keyword);
		
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null? "1" : pageNum;
		
		int pageNumInt = Integer.parseInt(pageNum);
		
		
		TopAdService service = new TopAdServiceImplMybatis();
		int total = service.TopAdListPagingTotalCnt(svo);
		List<TopAdVO> list = service.TopAdListPaging(pageNumInt,svo);
		
		req.setAttribute("TopdisplayList", list);
		
		//페이지기능
		//현재페이지정보, 페이지당 건수 , 전체데이터건수.
		Criteria cri = new Criteria(pageNumInt,10);
		PageDTO dto = new PageDTO(cri,total);
		req.setAttribute("pageDTO", dto);
		
		req.setAttribute("searchvo", svo);
		
		
		
		return "seller/topAd/topAd.tiles";
	}

}
