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

public class OrderDel implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int payId = Integer.parseInt(req.getParameter("payId"));

		PaymentService ps = new PaymentServiceImplMybatis();
		PaymentVO vo = ps.paymentSearch(payId);
		int r = ps.paymentDel(payId);

		if (r > 0) {
			ProductService product = new ProductServiceImplMybatis();
			ProductVO prod = product.prodSearch(vo.getProdId());
			int count = prod.getPayNum() + vo.getPayNum();
			product.prodSell(vo.getProdId(), count);
			
			CouponService cs = new CouponServiceImplMybatis();
			cs.couponSell(vo.getCpId());
		}
		return "orderList.do";
	}
}