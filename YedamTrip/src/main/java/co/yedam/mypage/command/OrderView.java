package co.yedam.mypage.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;
import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class OrderView implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int payId = Integer.parseInt(req.getParameter("payId"));
		
		PaymentService ps = new PaymentServiceImplMybatis();
		PaymentVO vo = ps.paymentSearch(payId);
		req.setAttribute("vo", vo);
		
		CouponService cs = new CouponServiceImplMybatis();
		CouponVO cvo = cs.UCouponSearch(vo.getCpId());
		req.setAttribute("cvo", cvo);
		
		ProductService prod = new ProductServiceImplMybatis();
		ProductVO pvo = prod.prodSearch(vo.getProdId());
		req.setAttribute("pvo", pvo);
		
		TripService trip = new TripServiceImplMybatis();
		TripVO tvo = trip.tripSearch(pvo.getTpId());
		req.setAttribute("tvo", tvo);
		
		return "user/mypage/orderView.tiles";
	}
}