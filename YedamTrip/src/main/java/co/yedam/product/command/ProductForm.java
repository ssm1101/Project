package co.yedam.product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class ProductForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		
		System.out.println(mbId);
		
		TripService service = new TripServiceImplMybatis();
		List<TripVO> list = service.tripMyList(mbId);

		req.setAttribute("tripList", list);
		
		return "seller/product/productForm.tiles";
	}

}
