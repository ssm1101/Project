package co.yedam.trip.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripFormEdit implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String tpId = req.getParameter("tpId");
		req.setAttribute("tpId", tpId);

		TripService service = new TripServiceImplMybatis();
		TripVO vo = service.tripSearch(Integer.parseInt(tpId));

		req.setAttribute("trip", vo);

		return "seller/trip/tripEdit.tiles";
	}
}