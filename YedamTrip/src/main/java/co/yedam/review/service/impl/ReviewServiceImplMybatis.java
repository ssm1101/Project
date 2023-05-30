package co.yedam.review.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Criteria;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.review.mapper.ReviewMapper;
import co.yedam.review.service.ReviewService;
import co.yedam.review.vo.ReviewVO;

public class ReviewServiceImplMybatis implements ReviewService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ReviewMapper mapper = session.getMapper(ReviewMapper.class);

	@Override
	public int insertReview(ReviewVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertReview(vo);
	}

	@Override
	public int reviewListPagingTotalCnt(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.reviewListPagingTotalCnt(svo);
	}


	@Override
	public int updateReview(ReviewVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateReview(vo);
	}

	@Override
	public int deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		return mapper.deleteReview(reviewId);
	}

	@Override
	public List<ReviewVO> reviewListPaging(int pageNum, SearchVO svo) {
		Criteria cri = new Criteria(pageNum, 10);
		cri.setSearchCondition(svo.getSearchCondition());
		cri.setKeyword(svo.getKeyword());
		return mapper.reviewListPaging(cri);
	}

	@Override
	public List<ReviewVO> reviewList(int prodId) {
		return mapper.reviewList(prodId);
	}

	@Override
	public ReviewVO reviewSearch(int reviewId) {
		// TODO Auto-generated method stub
		return mapper.reviewSearch(reviewId);
	}

	@Override
	public List<ReviewVO> myReview(String mbId) {
		// TODO Auto-generated method stub
		return mapper.myReview(mbId);
	}


}
