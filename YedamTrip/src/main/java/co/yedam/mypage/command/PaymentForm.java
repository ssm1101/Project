package co.yedam.mypage.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.service.impl.CouponServiceImplMybatis;
import co.yedam.coupon.vo.CouponVO;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class PaymentForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String tpName = req.getParameter("tpName");
		String tpText = req.getParameter("tpText");
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		String prodStart = req.getParameter("prodStart");
		String prodEnd = req.getParameter("prodEnd");
		int price = Integer.parseInt(req.getParameter("price"));
		int people = Integer.parseInt(req.getParameter("people"));
		int payNum = Integer.parseInt(req.getParameter("payNum"));
		String publisher = req.getParameter("publisher");

		req.setAttribute("tpName", tpName);
		req.setAttribute("tpText", tpText);
		req.setAttribute("prodId", prodId);
		req.setAttribute("prodStart", prodStart);
		req.setAttribute("prodEnd", prodEnd);
		req.setAttribute("payNum", payNum);
		req.setAttribute("people", people);
		req.setAttribute("price", price);
		
		MemberService ms = new MemberServiceImplMybatis();
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj; 
		MemberVO memberVO = ms.memberSearch(id);
		req.setAttribute("vo", memberVO);
		
		CouponService cs = new CouponServiceImplMybatis();
		List<CouponVO> cvo = cs.myCoupon(id, publisher);
		req.setAttribute("cvo", cvo);
		System.out.println(cvo);
		
		
		return "user/mypage/paymentForm.tiles";
	}
}
