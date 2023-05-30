package co.yedam.report.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.report.service.ReportService;
import co.yedam.report.service.impl.ReportServiceImplMybatis;
import co.yedam.report.vo.PackageReportVO;

public class PackageReportAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		String ReportCon = req.getParameter("ReportCon");
		String json="";
		
		PackageReportVO vo = new PackageReportVO();
		
		ReportService service = new ReportServiceImplMybatis();
		vo = service.tReportSearch(tpId);
		if(vo==null) {
			vo = new PackageReportVO();
			vo.setTpId(tpId);
			vo.setReportCon(ReportCon);
			int r=service.tReportAdd(vo);
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
