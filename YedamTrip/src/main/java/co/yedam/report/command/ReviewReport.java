package co.yedam.report.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;
import co.yedam.review.vo.ReviewVO;

public class ReviewReport implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		System.out.println(reviewId);
		
		ReportService service = new ReportServiceImplMybatis();
		
		ReviewVO vo = service.reviewSearch(reviewId);
		
		req.setAttribute("reviewList", vo);
		
		return "user/report/reviewReport.tiles";
	}

}
