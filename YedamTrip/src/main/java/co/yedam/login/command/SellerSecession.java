package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerSecession implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		
		MemberService service = new MemberServiceImplMybatis();
		
		int result = service.sellerDelete(mbId);
		
		String json ="";
		
		if(result>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		System.out.println(json);
		
		return "logout.do";
	}

}
