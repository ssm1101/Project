package co.yedam.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;
import co.yedam.mypage.vo.PaymentVO;

public class AdminChart implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj;
		
		PaymentService ps = new PaymentServiceImplMybatis();
		List<PaymentVO> psList = ps.sellerPayList();

		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(psList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json + ".ajax";
	}

}
