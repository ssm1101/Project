package co.yedam.likeIt.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.likeIt.service.LikeItService;
import co.yedam.likeIt.service.impl.LikeItServiceImplMybatis;
import co.yedam.likeIt.vo.LikeItVO;

public class LikeItDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		String mbId = req.getParameter("mbId");
		
		LikeItVO vo = new LikeItVO();
		vo.setTpId(tpId);
		vo.setMbId(mbId);
		
		LikeItService service = new LikeItServiceImplMybatis();
		int r = service.likeItDelete(vo);
		String json ="";
		if(r>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
	}

}
