package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;

public class ReviewReportTripDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int reviewId = Integer.parseInt(req.getParameter("reviewId"));
		
		ReportService service = new ReportServiceImplMybatis();
		
		int r = service.rReportTripDelete(reviewId);
		String json ="";
		if(r>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
