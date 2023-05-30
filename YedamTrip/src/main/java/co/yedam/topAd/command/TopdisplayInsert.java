package co.yedam.topAd.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;
import co.yedam.topAd.vo.TopAdVO;

public class TopdisplayInsert implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		int tpId = Integer.parseInt(req.getParameter("tpId"));
		String topStart = req.getParameter("topStart");
		String topEnd = req.getParameter("topEnd");
		
		TopAdVO vo = new TopAdVO();
		vo.setTpId(tpId);
		vo.setTopStart(topStart);
		vo.setTopEnd(topEnd);
		
		
		
		TopAdService service = new TopAdServiceImplMybatis();
		int r = service.TopdisplayInsert(vo);

		
		if(r>0) {
			return "tripList.do";
		}else {
			System.out.println("실패했습니다.");
			return "tripList.do";
		}
	
	}

}
