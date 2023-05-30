package co.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;

public class AdminMain implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PaymentService ps = new PaymentServiceImplMybatis();
		List<PaymentVO> psList = ps.sellerPayList();
		req.setAttribute("psList", psList);

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < psList.size(); i++) {
			int x = 0;
			if (psList.get(i).getTopPermiss().equals("O")) {
				x = (int) (Integer.parseInt(psList.get(i).getPrice()) * 0.1);
				System.out.println(x);
			} else if (psList.get(i).getTopPermiss().equals("X")) {
				x = (int) (Integer.parseInt(psList.get(i).getPrice()) * 0.05);
			}
			list.add(x);
		}

		req.setAttribute("list", list);

		return "seller/main/adminMain.tiles";
	}
}
