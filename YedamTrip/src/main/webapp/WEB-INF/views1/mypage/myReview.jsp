<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">리뷰 목록</h1>
						<span class="color-text-a">작성한 리뷰 내역을 확인할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<c:forEach var="vo" items="${myReview }">
						<div class="post-content color-text-a mb-4">
							<div class="row align-items-center">
								<div class="col-md-8">
									<h4 class="comment-author">@${vo.mbId }</h4>
									<span><i class="bi bi-star-fill"></i> <a>${vo.reviewStar }
									</a> / <a> ${vo.reviewDate }</a></span>
									<p class="comment-description">${vo.reviewCon }</p>
								</div>
								<div class="col-md-4" style="text-align: center;">
									<a
										href="myReviewSearch.do?reviewId=${vo.reviewId }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}&pageNum=${pageDTO.cri.pageNum}"
										class="btn btn-b-n"><i class="bi bi-pencil-square"></i></a> <a
										href="deleteMyReview.do?reviewId=${vo.reviewId }"
										class="btn btn-b-a"><i
										class="bi bi-trash-fill"></i></a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
</main>