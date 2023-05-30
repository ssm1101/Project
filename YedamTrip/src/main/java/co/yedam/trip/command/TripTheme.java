package co.yedam.trip.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripTheme implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		TripService Area = new TripServiceImplMybatis();
		List<TripVO> tripArea = Area.tripArea();
		req.setAttribute("tripArea", tripArea);		
				
		return "user/package/tripPackageSearch.tiles";
	}

}
