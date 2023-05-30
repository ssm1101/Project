package co.yedam.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;

public class InsertReview implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {		
		String reviewCon = req.getParameter("reviewCon");
		int reviewStar = Integer.parseInt(req.getParameter("reviewStar"));
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		String mbId = req.getParameter("mbId");
		
		ReviewVO vo = new ReviewVO();
		vo.setReviewCon(reviewCon);
		vo.setReviewStar(reviewStar);
		vo.setTpId(prodId);
		vo.setMbId(mbId);
		
		ReviewService service = new ReviewServiceImplMybatis();
		int r = service.insertReview(vo);
		
		if(r>0) {
			return r + ".ajax";
		}else {
			return null;
		}
		
	}
}