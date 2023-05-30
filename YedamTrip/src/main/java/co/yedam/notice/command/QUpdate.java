package co.yedam.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class QUpdate implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int psId = Integer.parseInt(req.getParameter("psId"));
		String psTitle = req.getParameter("psTitle");
		
		System.out.println(psId);
		System.out.println(psTitle);
		
		NoticeVO vo = new NoticeVO();
		vo.setPsId(psId);
		vo.setPsTitle(psTitle);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int r = service.qUpdate(vo);
		
		String json="";
		if(r>0) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
