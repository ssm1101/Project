package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerPermiss implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String mbId = req.getParameter("mbId");
		
		MemberService service = new MemberServiceImplMybatis();
		
		int result = service.sellerPermiss(mbId);
		
		String json ="";
		if(result>0) {
			json = "{\"retCode\": \"Success\"}";
		} else {
			json = "{\"retCode\": \"Fail\"}";
		}
		System.out.println(json);
		
		return "sellerList.do";
	}

}
