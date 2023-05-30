package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class MyPage implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		String mbId = (String) session.getAttribute("id");
		
		System.out.println(mbId);
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		vo.setMbId(mbId); //db로 보내줄 값을 가공, 정함
		vo = service.checkId(vo);  //db로 값을 보냄 service. -> 매퍼를 경유하여 보냄 
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(vo);
		
		String json="";
		
		try {
			json= mapper.writeValueAsString(vo);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json + ".ajax";
		}
	}


