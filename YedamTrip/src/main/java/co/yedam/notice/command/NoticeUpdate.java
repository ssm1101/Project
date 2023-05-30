package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String psTitle = req.getParameter("psTitle");
		String psText = req.getParameter("psText");
		int psId = Integer.parseInt(req.getParameter("psId"));
		String mbId = req.getParameter("mbId");
		
		NoticeVO vo = new NoticeVO();
		vo.setPsTitle(psTitle);
		vo.setPsText(psText);
		vo.setPsId(psId);
		vo.setMbId(mbId);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int r = service.noticeUpdate(vo);
		
		String json="";
		if(r>0) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
