package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;

public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int psId = Integer.parseInt(req.getParameter("psId"));
		
		NoticeService service = new NoticeServiceImplMybatis();
		
		int r = service.noticeDelete(psId);
		String json ="";
		if(r>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
