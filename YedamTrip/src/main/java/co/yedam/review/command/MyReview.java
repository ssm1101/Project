package co.yedam.review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.review.service.ReviewService;
import co.yedam.review.service.impl.ReviewServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;

public class MyReview implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		
		System.out.println(mbId);
		
		ReviewService service = new ReviewServiceImplMybatis();
		List<ReviewVO> list = service.myReview(mbId);

		req.setAttribute("myReview", list);
		
		return "user/mypage/myReview.tiles";
	}

}
