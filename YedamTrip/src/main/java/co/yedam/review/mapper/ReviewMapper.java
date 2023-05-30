package co.yedam.review.mapper;

import java.util.List;

import co.yedam.common.Criteria;
import co.yedam.common.SearchVO;
import co.yedam.review.vo.ReviewVO;

public interface ReviewMapper {
	// 리뷰 등록
	public int insertReview(ReviewVO vo);
	// 리뷰 조회
	public int reviewListPagingTotalCnt(SearchVO svo);
	public List<ReviewVO> reviewListPaging(Criteria cri);
	// 리뷰 수정
	public int updateReview(ReviewVO vo);
	// 리뷰 삭제
	public int deleteReview(int reviewId);
	public List<ReviewVO> reviewList(int tpId);
	public ReviewVO reviewSearch(int reviewId);	
	public List<ReviewVO> myReview(String mbId);
}
