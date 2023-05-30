package co.yedam.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;

public class ProductDel implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String prodId = req.getParameter("prodId");
		
		ProductService service = new ProductServiceImplMybatis();
		service.prodDel(Integer.parseInt(prodId));

		return "productList.do";
	}

}
