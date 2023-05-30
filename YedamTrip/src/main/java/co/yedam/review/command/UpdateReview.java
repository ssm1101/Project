package co.yedam.review.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;


public class UpdateReview implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		// update 구현.
		ReviewService service = new ReviewServiceImplMybatis();
		ReviewVO vo = new ReviewVO();

		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		int reviewStar = Integer.parseInt(req.getParameter("reviewStar"));
		String tpId = req.getParameter("tpId");
		String reviewCon = req.getParameter("reviewCon");
		
		vo.setReviewId(reviewId);
		vo.setReviewStar(reviewStar);
		vo.setReviewCon(reviewCon);
		System.out.println(vo);
		
		service.updateReview(vo);

		
		ReviewService service2 = new ReviewServiceImplMybatis();
		List<ReviewVO> list = service2.reviewList(Integer.parseInt(tpId));
		req.setAttribute("reviewList", list);

		
		return "reviewList.do?prodId=" + tpId + ".redirect";
	}

}
