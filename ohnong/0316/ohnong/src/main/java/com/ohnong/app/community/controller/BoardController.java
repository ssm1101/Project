	package com.ohnong.app.community.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohnong.app.community.service.BoardLikeService;
import com.ohnong.app.community.service.BoardService;
import com.ohnong.app.community.service.BoardVO;
import com.ohnong.app.community.service.Criteria_1;
import com.ohnong.app.community.service.PageDTO_1;
import com.ohnong.app.community.service.ReplyService;
import com.ohnong.app.community.service.ReplyVO;
import com.ohnong.app.community.service.ReportService;
import com.ohnong.app.community.service.ReportVO;
import com.ohnong.app.main.service.MemberVO;

//여원희. 커뮤니티게시판관리


@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	@Autowired
	ReplyService replyService;	
	
	@Autowired
	BoardLikeService boardLikeService;
	
	@Autowired
	ReportService reportService;
	
	
	//커뮤니티목록
	@GetMapping("community")
	public String communityList(Model model , Criteria_1 criteria) {
		
		model.addAttribute("boardList", boardService.getAllBoardList(criteria));
		
		model.addAttribute("pageMaker",new PageDTO_1(boardService.getTotal(criteria), 10, criteria));
			
		return "content/community/communityList";
	}

	//단건조회
	@GetMapping("communityView") 
	public String getcommunity(int boardBno, 
			                   HttpSession session,
			                   Model model, 
			                   Criteria_1 criteria, 
			                   RedirectAttributes rttr,
			                   String userId) {
		
		int likeCheck = boardLikeService.likeCheck(boardBno, userId);		
		model.addAttribute("like",likeCheck);
		
		MemberVO mvo=(MemberVO)session.getAttribute("login");		
		BoardVO vo = boardService.getBoard(boardBno);
		
		
		if(vo.getNoshow() == 1  ) {
			if(mvo == null  || !vo.getUserId().equals(mvo.getUserId()) && !mvo.getGrade().equals("1")) {
				
				rttr.addFlashAttribute("msg","이 글은 비밀글입니다 열람하실 수 없습니다.");
				
				return "redirect:community";	
				
			}
		}
		model.addAttribute("board", vo);
		return "content/community/communityView";	
	}
	
	
	//댓글 html불러오기
	@GetMapping(value="communityReply")
	public String replyHtml(@RequestParam(value="boardBno") int boardBno, Model model ,Criteria_1 criteria){
	
		//댓글가져오기
		List<ReplyVO> reply= replyService.getReplyList(criteria,boardBno);				
		model.addAttribute("replyList", reply);
		
		//댓글갯수
		int replyCount= replyService.replyCount(boardBno);		
		model.addAttribute("replyCount",replyCount);
		
		//댓글페이징
		model.addAttribute("pageMaker",new PageDTO_1(replyCount, 10, criteria));
		
		//관리자댓글 가져오기
		List<ReplyVO> adminReply= replyService.getAdminReply(boardBno);
		model.addAttribute("adminReply",adminReply);
		
		//카테고리별 댓글...
		BoardVO rvo = boardService.getBoard(boardBno);
		model.addAttribute("rvo",rvo);
		
		return "content/community/communityReply";
	}
	
	
	//글등록페이지로 이동
	@GetMapping("communityWrite")
	public String communityList(Model model) {
		
		return "content/community/communityWrite";
	}
	
	
	//글등록
	@RequestMapping("insert.do")
	public ModelAndView insertComAndCol(ModelAndView mv, BoardVO vo) {
	
		boardService.insertCommu(vo);
	
		mv.setViewName("redirect:community");
		return mv;
	}
	
	
	//댓글입력
	@ResponseBody
    @RequestMapping(value="replySubmit.do", method= RequestMethod.POST)
    public String replySubmit(int boardBno,
    						 String replyboardContent,
    						 String userId) {
    
       int result = replyService.insertReply(boardBno, replyboardContent , userId);
      
       String msg = "";
       if(result != 0) {
          msg = "success";
       }else {
          msg = "fail";
       }
      
       return msg;
    }
    
	//관리자의 댓글 입력
	@ResponseBody
    @RequestMapping(value="replyAdminSubmit.do", method= RequestMethod.POST)
    public String replyAdminSubmit(ReplyVO vo) {
    
       int result = replyService.insertAdminReply(vo);
       
       String msg = "";
       if(result != 0) {
          msg = "success";
       }else {
          msg = "fail";
       }
      
       return msg;
    }
    
	
	
	
	//글수정페이지
	@GetMapping("communityUpdate")
	public String communityUpdate(int boardBno, Model model) {
		
		BoardVO vo = boardService.getBoard(boardBno);
		
		model.addAttribute("board", vo);
		
		return "content/community/communityUpdate";
	}
	
	
	//글수정.
	@PostMapping("communityUpdate.do")
	public String updateCommu(BoardVO vo ,Criteria_1 criteria ) {
		
		boardService.modifyCommu(vo);

		PageDTO_1 pagemaker = new PageDTO_1(boardService.getTotal(criteria), 10, criteria);
		
		return "redirect:communityView?boardBno="+ vo.getBoardBno()
		                              + "&pageNum=" + pagemaker.getCriteria().getPageNum()
		                              + "&amount=10&type=" + pagemaker.getCriteria().getType()
				                      + "&keyword="+pagemaker.getCriteria().getKeyword()
				                      + "&category="+pagemaker.getCriteria().getCategory()
				                      + "&userId=" + vo.getUserId();
		
		
	}
	
	
	/////////////댓글수정
	
	@ResponseBody
	@RequestMapping(value="replyUpdate.do", method= RequestMethod.POST)
	public String replyUpdate(ReplyVO vo) {
		
		replyService.replyUpdate(vo);	
		return "success";
    }
	
	
	
	/////글 추천
	@ResponseBody
	@RequestMapping(value="updateLike", method=RequestMethod.POST)
	public int updateLike(int boardBno, String userId) {
		
		int result = boardLikeService.updateLike(boardBno, userId); 
		return result;	
	}
	
	
	//댓글삭제 exist 1로  update
	@ResponseBody
	@RequestMapping(value="deleteReply", method=RequestMethod.POST)
	public int deleteReply(int replyboardBno) {
		
		 int result = replyService.deleteReply(replyboardBno);
		
		 return result;
	}
	
	
	
	
	//글삭제 exist 1로  update
	@ResponseBody
	@RequestMapping(value="deleteBoard", method=RequestMethod.POST)
	public void deleteBoard(int boardBno, Criteria_1 criteria) {
			
		 boardService.deleteBoard(boardBno);
		 
	}
	
	
	//전문가에게 묻는 커뮤니티목록
	@GetMapping("communityPro")
	public String communityProList(Model model , 
								   Criteria_1 criteria,
								   RedirectAttributes rttr,
								   HttpSession session) {
		
		MemberVO mvo=(MemberVO)session.getAttribute("login");
		
		if(mvo != null  && mvo.getGrade().equals("1")) { //관리자이면
		
			model.addAttribute("boardList", boardService.proAnswerList(criteria));
			
			int result=boardService.getProTotal(criteria);
			
			model.addAttribute("pageMaker",new PageDTO_1(result, 10, criteria));
			
			model.addAttribute("total",result);
			
			return "content/community/communityProList";
		}
		
		rttr.addFlashAttribute("msg","이 페이지는 관리자용 페이지입니다");
		
		return "redirect:community";

	}
	
	
	//자신의 글 조회
	@GetMapping("mywrite")
	public String myWrite(Model model , 
						  Criteria_1 criteria,
						  HttpSession session) {		
		
		MemberVO mvo=(MemberVO)session.getAttribute("login");
		
		if(mvo != null) {
		
			model.addAttribute("boardList", boardService.getMyBoardList(criteria, mvo.getUserId()));	
			model.addAttribute("pageMaker",new PageDTO_1(boardService.getMyTotal(criteria ,mvo.getUserId()), 10, criteria));
			
			return "content/community/mywrite";
		}
		
		return "content/main/main";
	}
	
	//자신의 댓글조회
	@GetMapping("myreply")
	public String myreply( Model model , 
						  Criteria_1 criteria,
						  HttpSession session){
		
		MemberVO mvo=(MemberVO)session.getAttribute("login");
		
		if(mvo != null) {
			
			model.addAttribute("replyList", replyService.getMyReply(criteria,mvo.getUserId()));		
			
			model.addAttribute("pageMaker",new PageDTO_1(replyService.myReplyTotal(criteria,mvo.getUserId()), 10, criteria));
		 
			return  "content/community/myreply";
		}
		return "content/main/main";
	}
	
	
		//신고글 리스트.
		@GetMapping("reportList")
		public String reportList( Model model , 
							  Criteria_1 criteria,
							  HttpSession session,
							  RedirectAttributes rttr){
			
			MemberVO mvo=(MemberVO)session.getAttribute("login");
			
			if(mvo != null  && mvo.getGrade().equals("1")) { //관리자이면
				
				model.addAttribute("reportBoard", reportService.reportBoardList(criteria));
				
				model.addAttribute("pageMaker",new PageDTO_1(reportService.reportBoardTotal(criteria),10,criteria));
				
				return  "content/community/reportList";
			}
			
			rttr.addFlashAttribute("msg","이 페이지는 관리자용 페이지입니다");
			
			return "redirect:community";
		}
	
		
		
	
	//신고글 작성
	@ResponseBody
    @RequestMapping(value="reportWrite", method= RequestMethod.POST)
    public int reportWrite(ReportVO vo) {
     
	  int result = reportService.reportWrite(vo); 
      
       return result;
    }
	
	
	//신고받은 리스트
	@ResponseBody
    @RequestMapping(value="/reportList/{boardBno}", method= RequestMethod.POST)
    public List<ReportVO> reportList(@PathVariable("boardBno") int boardBno) {
		
		return reportService.reportList(boardBno);
    
	}
	
	
	//자신의 추천 글 목록 페이지
	@GetMapping("boardLike")
	public String boardLike(Model model , 
							  Criteria_1 criteria,
							  HttpSession session,
							  RedirectAttributes rttr) {		
			
			MemberVO mvo=(MemberVO)session.getAttribute("login");
			
			if(mvo != null) {
			
				model.addAttribute("boardList", boardLikeService.getLikeBoard(criteria, mvo.getUserId()));	
				model.addAttribute("pageMaker",new PageDTO_1(boardLikeService.getLikeTotal(criteria ,mvo.getUserId()), 10, criteria));
			
				return "content/community/boardLike";
			}
			
			rttr.addFlashAttribute("msg","이 페이지는 로그인 회원의 페이지입니다.");
			return "redirect:community";
		}
	
	
	  //글 블라인드 exist 5로  update
		@ResponseBody
		@RequestMapping(value="boardBlind", method=RequestMethod.POST)
		public int boardBlind(int boardBno) {
				
			int result = reportService.boardBlind(boardBno);
			 
			return result;
		}
		
		//블라인드 글 복구 exist 0으로  update
		@ResponseBody
		@RequestMapping(value="boardRestore", method=RequestMethod.POST)
		public int boardRestore(int boardBno) {
				
			int result = reportService.boardRestore(boardBno);
			 
			return result;
		}
	
}