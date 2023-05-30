package co.yedam.review.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.impl.ProductServiceImplMybatis;
import co.yedam.product.vo.ProductVO;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;


public class ReviewList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String prodId = req.getParameter("prodId");
		ProductService product = new ProductServiceImplMybatis();
		ProductVO vo = product.prodSearch(Integer.parseInt(prodId));
		req.setAttribute("prod", vo);
		
		int tpId = vo.getTpId();
		TripService trip = new TripServiceImplMybatis();
		TripVO tvo = trip.packageView(tpId);
		req.setAttribute("trip", tvo);

		
		ReviewService service = new ReviewServiceImplMybatis();
		List<ReviewVO> list = service.reviewList(Integer.parseInt(prodId));
		System.out.println(prodId);
		
		req.setAttribute("reviewList", list);
		
		return "user/review/review.tiles";
	}
}