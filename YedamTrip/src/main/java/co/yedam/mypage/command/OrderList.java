package co.yedam.mypage.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;

public class OrderList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PaymentService ps = new PaymentServiceImplMybatis();
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj; 
		List<PaymentVO> list = ps.paymentList(id);
	
		req.setAttribute("paymentList", list);
		
		return "user/mypage/orderList.tiles";
	}
}