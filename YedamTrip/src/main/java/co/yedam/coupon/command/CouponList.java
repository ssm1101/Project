package co.yedam.coupon.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;


public class CouponList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
//		String searchCondition = req.getParameter("searchCondition");
//		String keyword = req.getParameter("keyword");
//		
//		SearchVO svo =new SearchVO();
//		
//		svo.setSearchCondition(searchCondition);
//		svo.setKeyword(keyword);
//		
//		String pageNum = req.getParameter("pageNum");
//		pageNum = pageNum == null? "1" : pageNum;
//		
//		int pageNumInt = Integer.parseInt(pageNum);
//		
//		
//		CouponService service = new CouponServiceImplMybatis();
//		int total = service.couponListPagingTotalCnt(svo);
//		List<CouponVO> list = service.couponListPaging(pageNumInt,svo);
//		
//		req.setAttribute("CouponList", list);
//		
//		//페이지기능
//		//현재페이지정보, 페이지당 건수 , 전체데이터건수.
//		Criteria cri = new Criteria(pageNumInt,10);
//		PageDTO dto = new PageDTO(cri,total);
//		req.setAttribute("pageDTO", dto);
//		
//		req.setAttribute("searchvo", svo);		
		
		HttpSession session = req.getSession(true);
		String uId = (String) session.getAttribute("id");
		String mId = req.getParameter("memberList");
		
		CouponService service = new CouponServiceImplMybatis();
		List<CouponVO> list = service.CouponList();
		req.setAttribute("CouponList", list);
		req.setAttribute("LoginId", uId);
		
		
		return "seller/coupon/coupon.tiles";
	}

}
