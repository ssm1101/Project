package co.yedam.coupon.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.SearchVO;
import co.yedam.coupon.vo.CouponVO;

public interface CouponService {

	List<CouponVO> CouponList();
	
	public int CouponInsert(CouponVO vo);

	public int CouponUpdate(CouponVO vo);

	CouponVO CouponSearch(int parseInt);

	int CouponDelete(int id);

	int couponListPagingTotalCnt(SearchVO svo);

	List<CouponVO> couponListPaging(int pageNumInt, SearchVO svo);

	public List<CouponVO> myCoupon(@Param("mbId") String mbId, @Param("publisher") String publisher);

	public int couponUse(int ucpId);

	public CouponVO UCouponSearch(int ucpId);

	public int couponSell(int cpId);
}
