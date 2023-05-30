package co.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.AdminChart;
import co.yedam.common.AdminMain;
import co.yedam.common.Command;
import co.yedam.common.SellerChart;
import co.yedam.common.UserMain;
import co.yedam.common.SellerMain;
import co.yedam.coupon.command.CouponDelete;
import co.yedam.coupon.command.CouponInsert;
import co.yedam.coupon.command.CouponList;
import co.yedam.coupon.command.CouponSearch;
import co.yedam.coupon.command.CouponUpdate;
import co.yedam.likeIt.command.LikeItAdd;
import co.yedam.likeIt.command.LikeItDelete;
import co.yedam.likeIt.command.LikeItListForm;
import co.yedam.login.command.CheckId;
import co.yedam.login.command.FindPass;
import co.yedam.login.command.FindPassForm;
import co.yedam.login.command.LoginCheck;
import co.yedam.login.command.LoginForm;
import co.yedam.login.command.Logout;
import co.yedam.login.command.ModPageForm;
import co.yedam.login.command.MyPage;
import co.yedam.login.command.MyPageView;
import co.yedam.login.command.SellerCheckId;
import co.yedam.login.command.SellerDelete;
import co.yedam.login.command.SellerInfo;
import co.yedam.login.command.SellerInsert;
import co.yedam.login.command.SellerJoinForm;
import co.yedam.login.command.SellerList;
import co.yedam.login.command.SellerPage;
import co.yedam.login.command.SellerPermiss;
import co.yedam.login.command.SellerSecession;
import co.yedam.login.command.UpdateMember;
import co.yedam.login.command.UserDelete;
import co.yedam.login.command.UserInsert;
import co.yedam.login.command.UserJoinForm;
import co.yedam.login.command.UserList;
import co.yedam.login.command.ViewPass;
import co.yedam.login.memberVO.MemberVO;
import co.yedam.mypage.command.ModMyPage;
import co.yedam.mypage.command.OrderDel;
import co.yedam.mypage.command.OrderList;
import co.yedam.mypage.command.OrderView;
import co.yedam.mypage.command.PaymentAdd;
import co.yedam.mypage.command.PaymentForm;
import co.yedam.notice.command.NoticeAdd;
import co.yedam.notice.command.NoticeAddForm;
import co.yedam.notice.command.NoticeDelete;
import co.yedam.notice.command.NoticeList;
import co.yedam.notice.command.NoticeListPaging;
import co.yedam.notice.command.NoticeMain;
import co.yedam.notice.command.NoticeMainList;
import co.yedam.notice.command.NoticeSearch;
import co.yedam.notice.command.NoticeUpdate;
import co.yedam.notice.command.Paging;
import co.yedam.notice.command.QAdd;
import co.yedam.notice.command.QAddProduct;
import co.yedam.notice.command.QDelete;
import co.yedam.notice.command.QUpdate;
import co.yedam.notice.command.QnaForm;
import co.yedam.notice.command.QnaSearch;
import co.yedam.notice.command.SellerQnaForm;
import co.yedam.notice.command.AdminQnaForm;
import co.yedam.notice.command.NoticeMainSearch;
import co.yedam.product.command.PackageItemList;
import co.yedam.product.command.ProductAdd;
import co.yedam.product.command.ProductDel;
import co.yedam.product.command.ProductEdit;
import co.yedam.product.command.ProductEditForm;
import co.yedam.product.command.ProductForm;
import co.yedam.product.command.ProductList;
import co.yedam.report.command.InsertReviewReport;
import co.yedam.report.command.PackageReport;
import co.yedam.report.command.PackageReportAdd;
import co.yedam.report.command.PackageReportDelete;
import co.yedam.report.command.PackageReportList;
import co.yedam.report.command.PackageReportListForm;
import co.yedam.report.command.ReviewReport;
import co.yedam.report.command.ReviewReportDelete;
import co.yedam.report.command.ReviewReportList;
import co.yedam.report.command.ReviewReportListForm;
import co.yedam.report.command.ReviewReportTripDelete;
import co.yedam.report.command.PackageReportTripDelete;
import co.yedam.review.command.DeleteMyReview;
import co.yedam.review.command.DeleteReview;
import co.yedam.review.command.InsertReview;
import co.yedam.review.command.MyReview;
import co.yedam.review.command.MyReviewSearch;
import co.yedam.review.command.ReviewList;
import co.yedam.review.command.ReviewSearch;
import co.yedam.review.command.UpdateMyReview;
import co.yedam.review.command.UpdateReview;
import co.yedam.topAd.command.TopdisplayDelete;
import co.yedam.topAd.command.TopdisplayInsert;
import co.yedam.topAd.command.TopdisplayList;
import co.yedam.topAd.command.TopdisplayPermiss;
import co.yedam.topAd.command.TopdisplayPermissList;
import co.yedam.topAd.command.TopdisplayView;
import co.yedam.trip.command.PackageList;
import co.yedam.trip.command.TripAdd;
import co.yedam.trip.command.TripArea;
import co.yedam.trip.command.TripDel;
import co.yedam.trip.command.TripEdit;
import co.yedam.trip.command.TripForm;
import co.yedam.trip.command.TripFormEdit;
import co.yedam.trip.command.TripKeywordSearch;
import co.yedam.trip.command.TripList;
import co.yedam.trip.command.TripTheme;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	HashMap<String, Command> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init() throws ServletException {
		// 사용자 페이지
		map.put("/userMain.do", new UserMain());
		
		//마이페이지
		map.put("/modMypage.do", new ModMyPage());
		map.put("/modPageForm.do", new ModPageForm());
		map.put("/myPageView.do",new MyPageView());
		map.put("/myPage.do", new MyPage());
		map.put("/DeleteU.do", new DeleteU());

		// 로그인
		map.put("/loginForm.do", new LoginForm());
		map.put("/loginCheck.do", new LoginCheck());
		map.put("/logout.do", new Logout());
		map.put("/userInsert.do", new UserInsert());
		map.put("/userJoinForm.do", new UserJoinForm());
		map.put("/sellerInsert.do", new SellerInsert());
		map.put("/sellerJoinForm.do", new SellerJoinForm());
		map.put("/checkId.do", new CheckId());
		map.put("/sellerCkeckId.do", new SellerCheckId());
		map.put("/findPass.do", new FindPass());
		map.put("/findPassForm.do", new FindPassForm());
		map.put("/viewPass.do", new ViewPass());		
		
		// 결제
		map.put("/paymentFrom.do", new PaymentForm());
		map.put("/paymentAdd.do", new PaymentAdd());
		map.put("/orderList.do", new OrderList());
		map.put("/orderView.do", new OrderView());
		map.put("/orderDel.do", new OrderDel());
				
		// 리뷰 관련
		map.put("/reviewList.do", new ReviewList());
		map.put("/insertReview.do", new InsertReview());
		map.put("/reviewSearch.do", new ReviewSearch());
		map.put("/updateReview.do", new UpdateReview());
		map.put("/deleteReview.do", new DeleteReview());
		
		// 마이페이지 리뷰
		map.put("/myReview.do", new MyReview());
		map.put("/myReviewSearch.do", new MyReviewSearch());
		map.put("/updateMyReview.do", new UpdateMyReview());
		map.put("/deleteMyReview.do", new DeleteMyReview());

		// 판매자 페이지
		map.put("/sellerMain.do", new SellerMain());
		map.put("/sellerPage.do", new SellerPage());
		map.put("/sellerInfo.do", new SellerInfo());
		map.put("/sellerChart.do", new SellerChart());
		map.put("/updateMember.do", new UpdateMember());
		map.put("/sellerSecession.do", new SellerSecession());

		// 관리자 페이지
		map.put("/adminMain.do", new AdminMain());
		map.put("/adminChart.do", new AdminChart());
		
		map.put("/userList.do", new UserList());
		map.put("/userDelete.do", new UserDelete());
		map.put("/sellerList.do", new SellerList());
		map.put("/sellerDelete.do", new SellerDelete());
		map.put("/sellerPermiss.do", new SellerPermiss());

		// 쿠폰
		map.put("/couponList.do", new CouponList());
		map.put("/couponInsert.do", new CouponInsert());
		map.put("/couponSearch.do", new CouponSearch());
		map.put("/couponUpdate.do", new CouponUpdate());
		map.put("/couponDelete.do", new CouponDelete());
		
		// 여행
		map.put("/tripList.do", new TripList());
		map.put("/tripFrom.do", new TripForm());
		map.put("/tripAdd.do", new TripAdd());
		map.put("/tripFormEdit.do", new TripFormEdit());
		map.put("/tripEdit.do", new TripEdit());
		map.put("/tripDel.do", new TripDel());
		map.put("/packageList.do", new PackageList());

		// 검색
		map.put("/tripKeywordSearch.do", new TripKeywordSearch());
		map.put("/tripTheme", new TripTheme());
		map.put("/tripArea", new TripArea());

		// 상품
		map.put("/productList.do", new ProductList());
		map.put("/productAdd.do", new ProductAdd());
		map.put("/productForm.do", new ProductForm());
		map.put("/productEdit.do", new ProductEdit());
		map.put("/productEditForm.do", new ProductEditForm());
		map.put("/productDel.do", new ProductDel());
		map.put("/packageItemList.do", new PackageItemList());

		// 공지사항
		map.put("/notice.do", new NoticeList());
		map.put("/noticeAddForm.do", new NoticeAddForm());
		map.put("/noticeAdd.do", new NoticeAdd());
		map.put("/noticeSearch.do", new NoticeSearch());
		map.put("/noticeUpdate.do", new NoticeUpdate());
		map.put("/noticeDelete.do", new NoticeDelete());
		map.put("/noticeMain.do", new NoticeMain());
		map.put("/noticeMainSearch.do", new NoticeMainSearch());
		map.put("/noticeMainList.do", new NoticeMainList());
		//map.put("/noticeList.do", new NoticeListPaging());
		//map.put("/paging.do()", new Paging());
		
		//QnA
		map.put("/qnaForm.do", new QnaForm());
		map.put("/qAdd.do", new QAdd());
		map.put("/qAddProduct.do", new QAddProduct());
		map.put("/qUpdate.do", new QUpdate());
		map.put("/qDelete.do", new QDelete());
		map.put("/adminQnaForm.do", new AdminQnaForm());
		map.put("/sellerQnaForm.do", new SellerQnaForm());
		map.put("/qnaSearch.do", new QnaSearch());
		
		// 패키지신고
		map.put("/packageReport.do", new PackageReport());
		map.put("/packageReportAdd.do", new PackageReportAdd());
		map.put("/packageReportListForm.do", new PackageReportListForm());
		map.put("/packageReportList.do", new PackageReportList());
		map.put("/packageReportDelete.do", new PackageReportDelete());
		map.put("/packageReportTripDelete.do", new PackageReportTripDelete());
		
		// 리뷰신고
		map.put("/reviewReport.do", new ReviewReport());
		map.put("/insertReviewReport.do", new InsertReviewReport());	
		map.put("/reviewReportListForm.do", new ReviewReportListForm());
		map.put("/reviewReportList.do", new ReviewReportList());
		map.put("/reviewReportDelete.do", new ReviewReportDelete());
		map.put("/reviewReportTripDelete.do", new ReviewReportTripDelete());
		
		//찜
		map.put("/likeItAdd.do", new LikeItAdd());
		map.put("/likeItListForm.do", new LikeItListForm());
		map.put("/likeItDelete.do", new LikeItDelete());
		
		// 상단노출
		map.put("/topdisplayPermiss.do", new TopdisplayPermiss());
		map.put("/topdisplayDelete.do", new TopdisplayDelete());
		map.put("/topdisplayInsert.do", new TopdisplayInsert());
		map.put("/topdisplayPermissList.do", new TopdisplayPermissList());
		map.put("/topdisplayList.do", new TopdisplayList());
		map.put("/topdisplayView.do", new TopdisplayView());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("==> " + page);

		Command command = map.get(page);
		String viewPage = command.exec(req, resp);
		
		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);

		} else if (viewPage.endsWith(".tiles")) {
			RequestDispatcher rd = req.getRequestDispatcher(viewPage);
			rd.forward(req, resp);

		} else if (viewPage.endsWith(".ajax")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() - 5));
		}
		
		else if (viewPage.endsWith(".redirect")) {
			
			String view = viewPage.substring(0, viewPage.length() - 9);
			resp.sendRedirect(view);
			
		}
	}
}