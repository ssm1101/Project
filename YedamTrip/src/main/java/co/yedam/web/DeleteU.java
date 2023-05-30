package co.yedam.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class DeleteU implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("id");
		String id = (String)obj;
		
	
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		vo.setMbId(id);
		service.userDelete(id);
	
		session.invalidate();
	
		return "userMain.do";
	}

}

