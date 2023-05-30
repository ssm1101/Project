package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class FindPass implements Command {
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String mbId = req.getParameter("mbId");
		String mbPhone = req.getParameter("mbPhone");	
		
		MemberVO vo = new MemberVO();
		vo.setMbId(mbId);
		vo.setMbPhone(mbPhone);
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO result = service.findPass(vo);
	
		req.setAttribute("pw", result.getMbPw());
		return  "user/login/viewPass.tiles";
	}
}