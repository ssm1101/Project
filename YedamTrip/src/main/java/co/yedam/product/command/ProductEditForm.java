package co.yedam.product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class ProductEditForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		
		TripService trip = new TripServiceImplMybatis();
		List<TripVO> myList = trip.tripMyList(mbId);

		req.setAttribute("tripList", myList);
		
		
		String prodId = req.getParameter("prodId");
		
		ProductService service = new ProductServiceImplMybatis();
		ProductVO vo = service.prodSearch(Integer.parseInt(prodId));
		
		req.setAttribute("prodId", prodId);
		req.setAttribute("product", vo);
		
		return "seller/product/productEditForm.tiles";
	}
}
