package co.yedam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;

public class SellerMain implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj;
		
		PaymentService ps = new PaymentServiceImplMybatis();
		List<PaymentVO> psList = ps.myPayList(id);
		
		req.setAttribute("psList", psList);
		
		return "seller/main/sellerMain.tiles";
	}

}
