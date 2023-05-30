package co.yedam.trip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripEdit implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String tpId = req.getParameter("tpId");
		String tpName = req.getParameter("tpName");
		String tpText = req.getParameter("tpText");
		String tpImg = req.getParameter("tpImg");
		String tpArea = req.getParameter("tpArea");
		String tpTheme = req.getParameter("tpTheme");
		String tpDate = req.getParameter("tpDate");

		TripVO vo = new TripVO();
		vo.setTpId(Integer.parseInt(tpId));
		vo.setTpName(tpName);
		vo.setTpText(tpText);
		vo.setTpImg(tpImg);
		vo.setTpArea(tpArea);
		vo.setTpTheme(tpTheme);
		vo.setTpDate(tpDate);
		
		TripService service = new TripServiceImplMybatis();
		service.tripUpdate(vo);
		req.setAttribute("vo", vo);

		return "tripList.do";
	}
}