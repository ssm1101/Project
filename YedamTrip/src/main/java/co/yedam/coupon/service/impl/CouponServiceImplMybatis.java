package co.yedam.coupon.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Criteria;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.coupon.mapper.CouponMapper;
import co.yedam.coupon.service.CouponService;
import co.yedam.coupon.vo.CouponVO;

public class CouponServiceImplMybatis implements CouponService {

	SqlSession session = DataSource.getInstance().openSession(true);
	CouponMapper mapper = session.getMapper(CouponMapper.class);
	
	@Override
	public List<CouponVO> CouponList() {
		// TODO Auto-generated method stub
		return mapper.CouponList();
	}

	@Override
	public int CouponInsert(CouponVO vo) {
		// TODO Auto-generated method stub
		return mapper.CouponInsert(vo);
	}

	@Override
	public int CouponUpdate(CouponVO vo) {
		// TODO Auto-generated method stub
		return mapper.CouponUpdate(vo);
	}

	@Override
	public CouponVO CouponSearch(int couponId) {
		// TODO Auto-generated method stub
		return mapper.CouponSearch(couponId);
	}

	@Override
	public int CouponDelete(int id) {
		return mapper.CouponDelete(id);
		
	}

	@Override
	public int couponListPagingTotalCnt(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.couponListPagingTotalCnt(svo);
	}

	@Override
	public List<CouponVO> couponListPaging(int pageNum, SearchVO svo) {
		//mybatis parameter로 넘기기 위해 Criteria 활용
		Criteria cri = new Criteria(pageNum, 10);
		cri.setSearchCondition(svo.getSearchCondition());
		cri.setKeyword(svo.getKeyword());
		
		return mapper.couponListPaging(cri);
	}

	@Override
	public List<CouponVO> myCoupon(@Param("mbId") String mbId, @Param("publisher") String publisher) {
		return mapper.myCoupon(mbId, publisher);
	}

	@Override
	public int couponUse(int ucpId) {
		return mapper.couponUse(ucpId);
	}

	@Override
	public CouponVO UCouponSearch(int ucpId) {
		return mapper.UCouponSearch(ucpId);
	}

	@Override
	public int couponSell(int ucpId) {
		return mapper.couponSell(ucpId);
	}
}
