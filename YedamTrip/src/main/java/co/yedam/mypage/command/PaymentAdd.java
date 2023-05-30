package co.yedam.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;

public class PaymentAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		int payPrice = Integer.parseInt(req.getParameter("payPrice"));
		int people = Integer.parseInt(req.getParameter("people"));
		int ucpId = Integer.parseInt(req.getParameter("ucpId"));
		String mbId = req.getParameter("mbId");
		int payNum = Integer.parseInt(req.getParameter("payNum"));
		String mbName = req.getParameter("mbName");
		String mbPhone = req.getParameter("mbPhone");

		PaymentVO vo = new PaymentVO();
		vo.setProdId(prodId);
		vo.setPayPrice(payPrice);
		vo.setPayNum(people);
		vo.setCpId(ucpId);
		vo.setMbId(mbId);
		vo.setPayName(mbName);
		vo.setPayPhone(mbPhone);

		PaymentService service = new PaymentServiceImplMybatis();

		int r = service.paymentAdd(vo);

		if (r > 0) {
			ProductService product = new ProductServiceImplMybatis();
			int count = payNum - people;
			product.prodSell(prodId, count);
			
			CouponService cs = new CouponServiceImplMybatis();
			cs.couponUse(vo.getCpId());

			return "orderList.do";
		} else {
			return "paymentForm.do";
		}
	}
}
