package co.yedam.coupon.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;

public class CouponDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String cId = req.getParameter("num");
		System.out.println(cId);
		int id = Integer.parseInt(cId);		
		
		CouponService service = new CouponServiceImplMybatis();
		service.CouponDelete(id);
		
		return "couponList.do";
	}
}
