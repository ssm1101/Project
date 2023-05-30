package co.yedam.trip.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj;
		
		TripService service = new TripServiceImplMybatis();
		List<TripVO> list = service.tripMyList(id);

		req.setAttribute("tripList", list);

		return "seller/trip/tripList.tiles";
	}
}