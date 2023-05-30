package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;

public class PackageReportListForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pageNum = req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		ReportService service = new ReportServiceImplMybatis();
		int total = service.tReportListPagingTotalCnt();
		Criteria cri = new Criteria(pageNumInt,10);
		PageDTO dto = new PageDTO(cri,total);
		System.out.println(dto);
		req.setAttribute("pageDTO", dto);
		
		return "seller/report/reportTrip.tiles";
	}

}
