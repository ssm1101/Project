package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerCheckId implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String sId = req.getParameter("sId");
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		
		vo.setMbId(sId);
		vo = service.checkId(vo);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json="";
		
		try {
			json= mapper.writeValueAsString(vo);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json + ".ajax";
		}

	}
