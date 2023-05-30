package co.yedam.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerInsert implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String sname = req.getParameter("mbName");
		String sid = req.getParameter("mbId");
		String spw = req.getParameter("mbPw");
		String semail = req.getParameter("mbEmail");
		String sphone = req.getParameter("mbPhone");
		//String sfile = req.getParameter("sfile");
		
		MemberVO vo = new MemberVO();
		vo.setMbId(sid);
		vo.setMbName(sname);
		vo.setMbPw(spw);
		vo.setMbPhone(sphone);
		vo.setMbEmail(semail);
		//vo.setBsCode(sfile);
		
		System.out.println(vo);
		
		MemberService service = new MemberServiceImplMybatis();
		int result = service.sellerInsert(vo);
		String json="";
		
		System.out.println(result);
		if(result>0) {
			json= "{\"retCode\" : \"Success\"}";	
		}else {
			json ="{\"retCode\" : \"Fail\"}";
		}
		return json + ".ajax";
	}

}
