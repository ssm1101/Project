package co.yedam.trip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripDel implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String tpId = req.getParameter("tpId");
		
		TripService service = new TripServiceImplMybatis();
		service.tripDel(Integer.parseInt(tpId));
		
		ProductService product = new ProductServiceImplMybatis();
		product.prodAllDel(Integer.parseInt(tpId));

		return "tripList.do";
	}
}
