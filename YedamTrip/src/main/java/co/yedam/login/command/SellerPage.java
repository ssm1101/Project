package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerPage implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		Object obj = session.getAttribute("id");
		String id = (String)obj; 
		System.out.println(obj);
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = service.memberSearch(id);
		
		req.setAttribute("vo", vo);
		
		return "seller/member/sellerInfo.tiles";
	}

}
