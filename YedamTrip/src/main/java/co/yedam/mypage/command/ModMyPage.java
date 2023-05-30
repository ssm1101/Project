package co.yedam.mypage.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;
import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.service.impl.PaymentServiceImplMybatis;


public class ModMyPage implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String mbId = req.getParameter("mbId");
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		
		MemberVO vo = new MemberVO();
		vo.setMbPw(pw);
		vo.setMbPhone(phone);
		vo.setMbEmail(email);
		vo.setMbId(mbId);
		PaymentService service = new PaymentServiceImplMybatis();
		int r = service.modMyPage(vo);
		
		String json="";
		if(r > 0 ) {
			json="{\"retCode\": \"Success\"}";
		} else {
			json="{\"retCode\": \"Fail\"}";
		}
		return json + ".ajax";
		
	}
}