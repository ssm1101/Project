package co.yedam.trip.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Command;
import co.yedam.trip.service.TripService;
import co.yedam.trip.service.impl.TripServiceImplMybatis;
import co.yedam.trip.vo.TripVO;

public class TripAdd implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String savePath = req.getServletContext().getRealPath("/attech");

		MultipartRequest multi;
		try {
			multi = new MultipartRequest(req, savePath, 1024 * 1024 * 10, "utf-8", new DefaultFileRenamePolicy());

			String tpName = multi.getParameter("tpName");
			String tpText = multi.getParameter("tpText");
			String tpImg = multi.getParameter("tpImg");
			String tpArea = multi.getParameter("tpArea");
			String tpTheme = multi.getParameter("tpTheme");
			String tpDate = multi.getParameter("tpDate");
			String mbId = multi.getParameter("mbId");

			Enumeration<?> files = multi.getFileNames();
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();
				tpImg = multi.getFilesystemName(file);
			}

			TripVO vo = new TripVO();
			vo.setTpName(tpName);
			vo.setTpText(tpText);
			vo.setTpImg(tpImg);
			vo.setTpArea(tpArea);
			vo.setTpTheme(tpTheme);
			vo.setTpDate(tpDate);
			vo.setMbId(mbId);

			TripService service = new TripServiceImplMybatis();
			int r = service.tripAdd(vo);

			if (r > 0) {
				return "tripList.do";
			} else {
				return "tripFrom.do";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}