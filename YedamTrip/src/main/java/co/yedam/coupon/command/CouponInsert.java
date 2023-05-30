package co.yedam.coupon.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;

public class CouponInsert implements Command{

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
	
		HttpSession session = req.getSession(true);
		String uId = (String) session.getAttribute("id");
		
		int cRate = Integer.parseInt(req.getParameter("couponRate"));
		String cName = req.getParameter("couponName");
		String cEffect = req.getParameter("couponEffective");
				
		CouponVO vo = new CouponVO();
		vo.setCpName(cName);
		vo.setCpExpire(cEffect);
		vo.setCpRate(cRate);
		vo.setCpPublisher(uId);
		
		CouponService service = new CouponServiceImplMybatis();
		int r = service.CouponInsert(vo);
		

		if(r>0) {
			return "couponList.do";
		}else {
			return "couponList.do";
		}
		
	}
}
