package co.yedam.mypage.service;

import java.util.List;

import co.yedam.login.memberVO.MemberVO;
import co.yedam.mypage.vo.PaymentVO;

public interface PaymentService {

	public int paymentAdd(PaymentVO vo);
	
	public int modMyPage(MemberVO vo);
	
	public MemberVO myPageView(MemberVO vo);
	
	public List<PaymentVO> paymentList(String mbId);
	
	public PaymentVO paymentSearch(int payId);
	
	public int paymentDel(int payId);

	public List<PaymentVO> myPayList(String mbId);

	public List<PaymentVO> sellerPayList();
}
