package co.yedam.login.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class UpdateMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session = req.getSession(true);
		String mbId = (String) session.getAttribute("id");
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = new MemberVO();
		
		String mbPw = req.getParameter("mbPw");
		String mbPhone = req.getParameter("mbPhone");
		String mbEmail = req.getParameter("mbEmail");
		
		vo.setMbId(mbId);
		vo.setMbPw(mbPw);
		vo.setMbPhone(mbPhone);
		vo.setMbEmail(mbEmail);
		
		System.out.println(vo);
		
		service.updateMember(vo);
		
		System.out.println(vo);
		
		return "sellerMain.do";
	}

}
