package co.yedam.trip.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripKeywordSearch implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String tName = req.getParameter("tripName");
		String tArea = req.getParameter("tripArea");
		String tTheme = req.getParameter("tripTheme");
		
		TripVO vo = new TripVO();
		vo.setTpName(tName);
		vo.setTpArea(tArea);
		vo.setTpTheme(tTheme);
		
		TripService service = new TripServiceImplMybatis();
		
		List<TripVO> list = service.tripKeywordSearch(vo);
		
		System.out.println(list);
		
		req.setAttribute("tripKeywordSearch", list);
		TripVO tvo = new TripVO();
		TripService serv = new TripServiceImplMybatis();
		List<TripVO> tripList = serv.packageList(tvo);
		req.setAttribute("tripList2", tripList);
		
		
		TripService Theme = new TripServiceImplMybatis();
		List<TripVO> tripTheme = Theme.tripTheme();
		req.setAttribute("tripTheme", tripTheme);
		
		TripService Area = new TripServiceImplMybatis();
		List<TripVO> tripArea = Area.tripArea();
		req.setAttribute("tripArea", tripArea);
		
		
				
		return "user/package/tripPackageSearch.tiles";
	}

}
