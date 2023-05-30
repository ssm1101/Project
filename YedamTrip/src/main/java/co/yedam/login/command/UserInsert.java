package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class UserInsert implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String mname = req.getParameter("mbName");
		String mid = req.getParameter("mbId");
		String mpw = req.getParameter("mbPw");
		String memail = req.getParameter("mbEmail");
		String mphone = req.getParameter("mbPhone");
		
		MemberVO vo = new MemberVO();
		vo.setMbId(mid);
		vo.setMbName(mname);
		vo.setMbPw(mpw);
		vo.setMbPhone(mphone);
		vo.setMbEmail(memail);
		
		System.out.println(vo);
		
		MemberService service = new MemberServiceImplMybatis();
		int result = service.userInsert(vo);
		String json = "";
		
		if (result > 0) {  
			json = "{\"retCode\": \"Success\"}";
		}else {
			json = "{\"retCode\": \"Fail\"}";
		}
		return  json + ".ajax";
		
	}

}