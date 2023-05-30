package co.yedam.topAd.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.service.impl.TopAdServiceImplMybatis;
import co.yedam.topAd.vo.TopAdVO;
import co.yedam.topAd.vo.TopAdViewVO;

public class TopdisplayPermissList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		TopAdService service = new TopAdServiceImplMybatis();		
		List<TopAdVO> list = service.TopdisplayPermissList();		
		req.setAttribute("TopdisplayPermissList", list);
		
		TopAdService tdv = new TopAdServiceImplMybatis();
		List<TopAdViewVO> list2 = tdv.TopdisplayView();
		req.setAttribute("TopdisplayView", list2);	
		
		
		return "seller/topAd/topAdPermiss.tiles";
	}

}
