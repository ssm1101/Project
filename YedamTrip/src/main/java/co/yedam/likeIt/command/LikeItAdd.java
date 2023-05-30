package co.yedam.likeIt.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.likeIt.service.LikeItService;
import co.yedam.likeIt.service.impl.LikeItServiceImplMybatis;
import co.yedam.likeIt.vo.LikeItVO;

public class LikeItAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		String mbId = req.getParameter("mbId");
		String json="";
		
		LikeItVO vo = new LikeItVO();
		vo.setTpId(tpId);
		vo.setMbId(mbId);
		
		LikeItService service = new LikeItServiceImplMybatis();
		vo = service.likeItSearch(vo);
		
		if(vo==null) {
			vo = new LikeItVO();
			vo.setTpId(tpId);
			vo.setMbId(mbId);
			int r=service.likeItAdd(vo);
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
