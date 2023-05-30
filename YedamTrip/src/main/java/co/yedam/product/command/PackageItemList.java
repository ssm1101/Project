package co.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class PackageItemList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		TripService tripService = new TripServiceImplMybatis();
		TripVO trip = tripService.tripSearch(tpId);
		req.setAttribute("trip", trip);
		
		ProductService service = new ProductServiceImplMybatis();
		List<ProductVO> list = service.productList(tpId);
		req.setAttribute("prodList", list);
		TripVO vo = new TripVO();
		
		TripService pl = new TripServiceImplMybatis();
		List<TripVO> pList = pl.packageList(vo);
		req.setAttribute("tripList2", pList);

		return "user/package/packageItemList.tiles";
	}
}