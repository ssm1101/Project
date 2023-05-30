package co.yedam.trip.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class PackageList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		TripService service = new TripServiceImplMybatis();
		TripVO vo = new TripVO();
		vo.setMbId((String)(req.getSession().getAttribute("id")));
		List<TripVO> tripList = service.packageList(vo);
		req.setAttribute("tripList", tripList);
		
		return "user/package/packageList.tiles";
	}
}