package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class LoginCheck implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession(true);

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		
		vo.setMbId(id);
		vo.setMbPw(pw);
		vo = service.loginCheck(vo);
	
		ObjectMapper mapper = new ObjectMapper();
		
		String json="";
		
		if (vo != null) {
			session.setAttribute("id", vo.getMbId());
			session.setAttribute("grade", vo.getMbGrade());	
		}
		
		try {
			json= mapper.writeValueAsString(vo);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		return json + ".ajax";
		}
	}
