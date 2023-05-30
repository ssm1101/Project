package co.yedam.login.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerInfo implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String mbName = req.getParameter("mbName");
		String mbId = req.getParameter("mbId");
		String mbPw = req.getParameter("mbPw");
		String mbPhone = req.getParameter("mbPhone");
		String mbEmail = req.getParameter("mbEmail");
		String bsCode = req.getParameter("bsCode");
		
		MemberService service = new MemberServiceImplMybatis();
		MemberVO vo = service.memberSearch(mbId);
		
		vo.setMbName(mbName);
		vo.setMbId(mbId);
		vo.setMbPw(mbPw);
		vo.setMbPhone(mbPhone);
		vo.setMbEmail(mbEmail);
		vo.setBsCode(bsCode);
		
		service.updateMember(vo);
		
		return "sellerPage.do";
	}

}
