package co.yedam.review.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.review.vo.ReviewVO;

public interface ReviewService {
	// 리뷰 등록
	public int insertReview(ReviewVO vo);
	// 리뷰 리스트
	public List<ReviewVO> reviewList(int prodId);
	// page에 따른 목록
	public List<ReviewVO> reviewListPaging(int pageNum, SearchVO svo);
	// page 목록 계산을 위한 건수
	public int reviewListPagingTotalCnt(SearchVO svo);
	// 리뷰 수정
	public int updateReview(ReviewVO vo);
	// 리뷰 삭제
	public int deleteReview(int reviewId);
	// 단건 조회 및 수정
	public ReviewVO reviewSearch(int reviewId);
	
	public List<ReviewVO> myReview(String mbId);
}
