package co.yedam.report.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.report.mapper.ReportMapper;
import co.yedam.report.service.ReportService;
import co.yedam.report.vo.PackageReportVO;
import co.yedam.report.vo.ReviewReportVO;
import co.yedam.review.vo.ReviewVO;
import co.yedam.trip.vo.TripVO;

public class ReportServiceImplMybatis implements ReportService {
	SqlSession session = DataSource.getInstance().openSession(true);
	ReportMapper mapper = session.getMapper(ReportMapper.class);
	@Override
	public TripVO tripPackageSearch(int tpId) {
		return mapper.tripPackageSearch(tpId);
	}
	@Override
	public int tReportAdd(PackageReportVO vo) {
		return mapper.tReportAdd(vo);
	}
	@Override
	public PackageReportVO tReportSearch(int tpId) {
		return mapper.tReportSearch(tpId);
	}
	@Override
	public int tReportListPagingTotalCnt() {
		return mapper.tReportListPagingTotalCnt();
	}
	@Override
	public List<PackageReportVO> tReportList(int pageNum) {
		return mapper.tReportList(pageNum);
	}
	@Override
	public int tReportDelete(int tpId) {
		return mapper.tReportDelete(tpId);
	}
	@Override
	public int tReportTripDelete(int tpId) {
		return mapper.tReportTripDelete(tpId);
	}
	@Override
	public List<ReviewReportVO> reportReview(int reviewId) {
		return mapper.rReportList(reviewId);
	}
	@Override
	public ReviewReportVO rReportSearch(int reviewId) {
		return mapper.rReportSearch(reviewId);
	}
	@Override
	public int insertReviewReport(ReviewReportVO vo) {
		return mapper.insertReviewReport(vo);
	}
	@Override
	public ReviewVO reviewSearch(int reviewId) {
		return mapper.reviewSearch(reviewId);
	}
	@Override
	public int rReportListPagingTotalCnt() {
		return mapper.rReportListPagingTotalCnt();
	}
	@Override
	public List<ReviewReportVO> rReportList(int pageNum) {
		return mapper.rReportList(pageNum);
	}
	@Override
	public int rReportDelete(int reviewId) {
		return mapper.rReportDelete(reviewId);
	}
	@Override
	public int rReportTripDelete(int reviewId) {
		return mapper.rReportReviewDelete(reviewId);
	}
}
