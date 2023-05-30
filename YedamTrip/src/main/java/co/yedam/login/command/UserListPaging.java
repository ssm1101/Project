package co.yedam.login.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class UserListPaging implements Command {
		@Override
		public String exec(HttpServletRequest req, HttpServletResponse resp) {
			
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
	
		Criteria cri = new Criteria(pageNum,10);
		System.out.println(pageNum);
		
		MemberService service = new MemberServiceImplMybatis();
		List<MemberVO> list = service.userList(pageNum);
		
		System.out.println(list);
			
		for(int i=0;i<list.size();i++) {
			MemberVO vo = new MemberVO();
			vo.setMbId(list.get(i).getMbId());
			vo.setMbName(list.get(i).getMbName());
			vo.setMbPhone(list.get(i).getMbPhone());
			vo.setMbEmail(list.get(i).getMbEmail());
			list.set(i, vo);
		}
		
		System.out.println(list);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(list);
			return json + ".ajax";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	return null;
	}

}
