package co.yedam.coupon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.Criteria;
import co.yedam.common.SearchVO;
import co.yedam.coupon.vo.CouponVO;


public interface CouponMapper {

	List<CouponVO> CouponList();

	int CouponInsert(CouponVO vo);

	public int CouponUpdate(CouponVO vo);

	CouponVO CouponSearch(int couponId);

	int CouponDelete(int id);

	int couponListPagingTotalCnt(SearchVO svo);

	List<CouponVO> couponListPaging(Criteria cri);

	List<CouponVO> myCoupon(@Param("mbId") String mbId, @Param("publisher") String publisher);

	public int couponUse(int ucpId);

	public CouponVO UCouponSearch(int ucpId);

	public int couponSell(int ucpId);

	int couponDistribute(CouponVO vo);

}
