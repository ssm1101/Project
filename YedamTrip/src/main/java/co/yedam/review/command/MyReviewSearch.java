package co.yedam.review.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;

public class MyReviewSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
			
		String pageNum = req.getParameter("pageNum");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
			
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("searchCondition", searchCondition);
		req.setAttribute("keyword", keyword);
			
		String num = req.getParameter("reviewId");
			
		ReviewService service = new ReviewServiceImplMybatis();
		ReviewVO vo = service.reviewSearch(Integer.parseInt(num));
			
		req.setAttribute("vo", vo);

		return "user/mypage/updateMyReview.tiles";
	}

}
