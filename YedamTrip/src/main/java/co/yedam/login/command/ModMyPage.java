package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;



public class ModMyPage implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//HttpSession session = req.getSession();
		//String Id = (String)session.getAttribute("id");
		//System.out.println(Id);
		
		String mbId = req.getParameter("mbId");
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		vo.setMbId(mbId);
		vo.setMbPw(pw);
		vo.setMbPhone(phone);
		vo.setMbEmail(email);
		
		System.out.println(vo);
		int result=service.modMyPage(vo);
		
		String json="";
		if(result > 0 ) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
		
	}
}
