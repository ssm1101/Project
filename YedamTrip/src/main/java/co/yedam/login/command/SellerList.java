package co.yedam.login.command;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.yedam.common.Command;
import co.yedam.common.Criteria;
import co.yedam.common.PageDTO;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.login.service.MemberService;
import co.yedam.login.service.impl.MemberServiceImplMybatis;

public class SellerList implements Command{

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String pageNum=req.getParameter("pageNum");
		pageNum = pageNum == null ? "1" : pageNum;
		int pageNumInt=Integer.parseInt(pageNum);
		
		MemberService service = new MemberServiceImplMybatis();
		int total=service.sellerListPagingTotalCnt();
		
		System.out.println(total);
		
		Criteria cri=new Criteria(pageNumInt,10);
		PageDTO dto=new PageDTO(cri, total);
		req.setAttribute("pageDTO", dto);
		System.out.println(dto);
			
		List<MemberVO> list = service.sellerList(pageNumInt);
		for(int i=0;i<list.size();i++) {
			MemberVO vo = new MemberVO();
			vo.setMbName(list.get(i).getMbName());
			vo.setMbId(list.get(i).getMbId());
			vo.setMbPhone(list.get(i).getMbPhone());
			vo.setMbEmail(list.get(i).getMbEmail());
			vo.setBsCode(list.get(i).getBsCode());
			vo.setSellPermiss(list.get(i).getSellPermiss());
			list.set(i, vo);
		}
		
		req.setAttribute("sellerList", list);
		
		return "seller/member/sellerList.tiles";
	}

}
