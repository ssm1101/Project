package co.yedam.notice.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.notice.service.NoticeService;
import co.yedam.notice.service.impl.NoticeServiceImplMybatis;
import co.yedam.notice.vo.NoticeVO;

public class QAddProduct implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		String mbId = req.getParameter("mbId");
		String psTitle = req.getParameter("psTitle");
		
		NoticeVO vo = new NoticeVO();
		vo.setMbId(mbId);
		vo.setPsTitle(psTitle);
		vo.setPsKind(prodId);
		
		NoticeService service = new NoticeServiceImplMybatis();
		int r = service.qAddProduct(vo);
		
		String json="";
		if(r>0) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
