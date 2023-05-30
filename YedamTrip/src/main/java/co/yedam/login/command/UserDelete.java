package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class UserDelete implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String mbId = req.getParameter("mbId");
		
		MemberService service = new MemberServiceImplMybatis();
		
		int result = service.userDelete(mbId);
		
		String json ="";
		
		if(result>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		
		System.out.println(json);
		
		return "userList.do";
	}

}

