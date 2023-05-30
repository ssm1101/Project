package co.yedam.coupon.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;

public class CouponUpdate implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		int cRate = Integer.parseInt(req.getParameter("couponRate"));
		String cID = req.getParameter("num");
		String cName = req.getParameter("couponName");
		String cEffect = req.getParameter("couponEffective");

		CouponService service = new CouponServiceImplMybatis();
		CouponVO vo = new CouponVO();
		
		int id = Integer.parseInt(cID);
		
		vo.setCpId(id);
		vo.setCpName(cName);
		vo.setCpExpire(cEffect);
		vo.setCpRate(cRate);		
		System.out.println(vo);

		service.CouponUpdate(vo);
		
		return "couponList.do";
		
		//////////////////////////////////////////////페이지정보.
//		
//		String searchCondition = req.getParameter("searchCondition");
//		String keyword = req.getParameter("keyword");
//		
//
//		
//		
//		SearchVO svo = new SearchVO();
//		svo.setSearchCondition(searchCondition);
//		svo.setKeyword(keyword);
//		
//		String pageNum = req.getParameter("pageNum");
//		pageNum = pageNum == null? "1" : pageNum;
//		int pageNumInt = Integer.parseInt(pageNum);
//		
//		CouponService service2 = new CouponServiceImplMybatis();
//		int total = service2.couponListPagingTotalCnt(svo);
//		List<CouponVO> list = service2.couponListPaging(pageNumInt,svo);
//		req.setAttribute("couponList", list);
//		
//		//페이지기능
//		//현재페이지정보, 페이지당 건수 , 전체데이터건수.
//		Criteria cri = new Criteria(pageNumInt,10);
//		PageDTO dto = new PageDTO(cri,total);
//		req.setAttribute("pageDTO", dto);
//		req.setAttribute("searchvo", svo);
	

	}

}
