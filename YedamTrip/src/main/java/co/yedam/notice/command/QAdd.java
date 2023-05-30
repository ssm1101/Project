package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class QAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String psTitle = req.getParameter("psTitle");
		String mbId = req.getParameter("mbId");
		
		NoticeVO vo = new NoticeVO();
		vo.setPsTitle(psTitle);
		vo.setMbId(mbId);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int r = service.qAdd(vo);
		
		String json="";
		if(r>0) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
