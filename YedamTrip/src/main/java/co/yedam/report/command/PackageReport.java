package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class PackageReport implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		System.out.println(tpId);
		ReportService service = new ReportServiceImplMybatis();
		TripVO vo = service.tripPackageSearch(tpId);
		
		req.setAttribute("tripPackageList", vo);
		
		return "user/report/packageReport.tiles";
	}

}
