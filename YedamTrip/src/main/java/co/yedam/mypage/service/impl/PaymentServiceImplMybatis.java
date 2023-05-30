package co.yedam.mypage.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.mypage.mapper.PaymentMapper;
import co.yedam.mypage.service.PaymentService;
import co.yedam.mypage.vo.PaymentVO;

public class PaymentServiceImplMybatis implements PaymentService {
	SqlSession session = DataSource.getInstance().openSession(true);
	PaymentMapper mapper = session.getMapper(PaymentMapper.class);

	@Override
	public int paymentAdd(PaymentVO vo) {
		return mapper.paymentAdd(vo);
	}

	@Override
	public int modMyPage(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.modMyPage(vo);
	}

	@Override
	public MemberVO myPageView(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.myPageView(vo);
	}

	@Override
	public List<PaymentVO> paymentList(String mbId) {
		return mapper.paymentList(mbId);
	}

	@Override
	public PaymentVO paymentSearch(int payId) {
		return mapper.paymentSearch(payId);
	}

	@Override
	public int paymentDel(int payId) {
		return mapper.paymentDel(payId);
	}

	@Override
	public List<PaymentVO> myPayList(String mbId) {
		return mapper.myPayList(mbId);
	}

	@Override
	public List<PaymentVO> sellerPayList() {
		return mapper.sellerPayList();
	}
}
