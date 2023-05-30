package co.yedam.report.service;

import java.util.List;

import co.yedam.report.vo.PackageReportVO;
import co.yedam.report.vo.ReviewReportVO;
import co.yedam.review.vo.ReviewVO;
import co.yedam.trip.vo.TripVO;

public interface ReportService {
	//패키지 정보 검색
	public TripVO tripPackageSearch(int tpId);
	//패키지 신고 등록
	public int tReportAdd(PackageReportVO vo);
	//패키지 신고 검색
	public PackageReportVO tReportSearch(int tpId);
	//패키지 신고글 수
	public int tReportListPagingTotalCnt();
	//패키지 신고 리스트
	public List<PackageReportVO> tReportList(int pageNum);
	//패키지 신고 삭제
	public int tReportDelete(int tpId);
	//패키지 신고 상품삭제
	public int tReportTripDelete(int tpId);
	//리뷰 신고 리스트
	public List<ReviewReportVO> reportReview(int reviewId);
	//리뷰 신고 검색
	public ReviewReportVO rReportSearch(int reviewId);
	//리뷰 신고 등록
	public int insertReviewReport(ReviewReportVO vo);
	//리뷰 검색
	public ReviewVO reviewSearch(int reviewId);
	//리뷰 신고글 수
	public int rReportListPagingTotalCnt();
	//리뷰 신고 리스트
	public List<ReviewReportVO> rReportList(int pageNumInt);
	//리뷰 신고 삭제
	public int rReportDelete(int reviewId);
	//리뷰 삭제
	public int rReportTripDelete(int reviewId);
}
