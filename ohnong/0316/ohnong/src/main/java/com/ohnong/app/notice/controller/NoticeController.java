package com.ohnong.app.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohnong.app.notice.service.Criteria_2;
import com.ohnong.app.notice.service.NoticeService;
import com.ohnong.app.notice.service.NoticeVO;
import com.ohnong.app.notice.service.PageMakerDTO;
 
@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service;
	
//	 @GetMapping(" ") 어노테이션은 @RequestMappign(vlaue=" ", method=RequestMethod.GET) 어노테이션과 동일한 역할.

//	공지사항 목록조회 페이지
	/*@GetMapping("/noticeList")
	public String noticeList(Model model) {
		model.addAttribute("noticeList", service.getAllList());
		return "content/notice/noticeList"; //
	}*/
	
//	공지사항 단건조회 페이지
	@GetMapping("/getNotice")
	public String getNotice(@RequestParam("noticeNo") int noticeNo, Model model, Criteria_2 cri) {
		
		
	    model.addAttribute("noticeList", service.getListPaging(cri));
	    
	    int total = service.getTotal(cri);
	    
	    PageMakerDTO pageMaker = new PageMakerDTO(cri,10, total);
	    
	    model.addAttribute("pageMaker", pageMaker);
	    
		NoticeVO vo = service.getNotice(noticeNo);
		model.addAttribute("notice", vo);
		return "content/notice/getNotice";
	}
	
//	공지사항 등록페이지 접속
	@GetMapping("/noticeRegister")
	public String noticeRegister() {
		
		return "content/notice/noticeRegister";
	}
	
//	공지사항 등록페이지 - 저장
	@PostMapping("/noticeRegister")
	public String noticeRegister(NoticeVO notice, RedirectAttributes rttr) {
		
		service.noticeRegister(notice);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:noticeList";
	}
	
	/*
	- 조회 페이지의 '수정 하기' 버튼(조회 페이지 -> 수정 페이지 이동)
	- 수정 페이지의 '목록 페이지' 버튼 (수정 페이지 -> 목록 페이지 이동)
	- 수정 페이지의 '수정 완료' 버튼 
    - 데이터베이스 수정 반영 - 수정 완료 후 목록 페이지 이동 - 목록 페이지서 경고창 확인
	- 수정 페이지의 '취소' 버튼(수정 페이지 -> 조회 페이지 이동) * */
	
//	공지사항 수정화면
	@GetMapping("/modifyNotice")
	public String modifyNotice(@RequestParam("noticeNo") int noticeNo, @ModelAttribute("cri") Criteria_2 cri,  Model model) {
		
		model.addAttribute("noticeList", service.getListPaging(cri));
	    
	    int total = service.getTotal(cri);
	    
	    PageMakerDTO pageMake = new PageMakerDTO(cri, 10,total);
	    
	    model.addAttribute("pageMaker", pageMake);
	    
	    
	    
	    
	    
		NoticeVO vo = service.getNotice(noticeNo);
		model.addAttribute("notice",vo);
		
		return "content/notice/modify";	
	}
	
//	공지사항 수정 - 저장
	@PostMapping("/modifyNotice")
	public String modifyNotice(NoticeVO notice,  RedirectAttributes rttr, Model model,  @ModelAttribute("cri") Criteria_2 cri) {
		
		model.addAttribute("noticeList", service.getListPaging(cri));
	    
	    int total = service.getTotal(cri);
	    
	    PageMakerDTO pageMake = new PageMakerDTO(cri, 10,total);
	    
	    model.addAttribute("pageMaker", pageMake);
	    
		service.modify(notice);
		
		rttr.addFlashAttribute("result", "modify success");
		
		System.out.println(cri.getKeyword() + cri.getType());
		return "redirect:getNotice?noticeNo="+notice.getNoticeNo()+"&keyword="+cri.getKeyword()+"&type="+cri.getType();
	}

//	공지사항 수정 - 저장
//	@RequestMapping(value = "/deleteNotice")
//	@PostMapping("/deleteNotice")
	@GetMapping("/deleteNotice")
	public String deleteNotice(NoticeVO notice,  RedirectAttributes rttr) {
		
		service.delete(notice);
		rttr.addFlashAttribute("result", "delete success");
			
		return "redirect:noticeList";
	}
	
	
	
	
	// 
	/* 게시판 목록 페이지 접속(페이징 적용) @RequestParam(defaultValue="1") */
    @GetMapping("/noticeList")
    public String boardListGET(Model model , Criteria_2 cri) { 
    	
    model.addAttribute("noticeList", service.getListPaging(cri));
    
    int total = service.getTotal(cri);
    
    PageMakerDTO pageMaker = new PageMakerDTO(cri,10 ,total);
    
    model.addAttribute("pageMaker", pageMaker);
    
        return "content/notice/noticeList";
    }
	
	
}
