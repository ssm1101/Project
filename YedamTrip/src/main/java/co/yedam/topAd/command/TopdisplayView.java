package co.yedam.topAd.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;
import co.yedam.topAd.vo.TopAdVO;
import co.yedam.topAd.vo.TopAdViewVO;

public class TopdisplayView implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		TopAdService service = new TopAdServiceImplMybatis();
		
		List<TopAdViewVO> list = service.TopdisplayView();
		System.out.println(list);		
		req.setAttribute("TopdisplayView", list);	
		
		return "seller/topAd/topAdPermiss.tiles";
	}
		

		
}


