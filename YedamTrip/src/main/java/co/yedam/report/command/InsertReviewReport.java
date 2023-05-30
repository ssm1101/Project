package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;
import co.yedam.report.vo.ReviewReportVO;

public class InsertReviewReport implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		String ReportCon = req.getParameter("ReportCon");
		String json="";
		
		ReviewReportVO vo = new ReviewReportVO();
		
		ReportService service = new ReportServiceImplMybatis();
		vo = service.rReportSearch(reviewId);
		if(vo==null) {
			vo = new ReviewReportVO();
			vo.setReviewId(reviewId);
			vo.setReportCon(ReportCon);
			int r=service.insertReviewReport(vo);
			System.out.println(r);
			
			if(r>0) {
				json="{\"retCode\": \"Success\"}";
			} else {
				json="{\"retCode\": \"Fail\"}";
			}
		}else {
			json="{\"retCode\": \"Overlap\"}";
		}
		
		return json + ".ajax";
	}

}
