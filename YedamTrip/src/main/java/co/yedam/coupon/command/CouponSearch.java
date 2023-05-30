package co.yedam.coupon.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class CouponSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String cpRate = req.getParameter("cpRate");
		String cpName = req.getParameter("cpName");
		String cpExpire = req.getParameter("cpExpire");
		String cId = req.getParameter("num");
		
		CouponVO vo = new CouponVO();
		vo.setCpRate(Integer.parseInt(cpRate));
		vo.setCpName(cpName);
		vo.setCpExpire(cpExpire);
		vo.setCpId(Integer.parseInt(cId));
		
		CouponService service = new CouponServiceImplMybatis();		
		req.setAttribute("vo", vo);
		
		return "/seller/coupon/couponSearch.tiles";
	}

}
