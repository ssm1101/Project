package co.yedam.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;

public class UpdateReviewForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		req.setAttribute("reviewId", reviewId);

		ReviewService service = new ReviewServiceImplMybatis();
		ReviewVO vo = service.reviewSearch(reviewId);

		req.setAttribute("review", vo);

		return "user/review/updateReviewForm.tiles";
	}

}
