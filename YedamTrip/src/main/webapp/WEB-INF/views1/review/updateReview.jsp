<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">리뷰 수정</h1>
						<span class="color-text-a">작성한 리뷰를 수정할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<form name="myFrm" action="updateReview.do">
						<div class="post-content color-text-a mb-4">
							<div class="row align-items-center">
								<input type="hidden" name="reviewId" value="${vo.reviewId }">
								<input type="hidden" name="pageNum" value="${pageNum}">
								<input type="hidden" name="searchCondition"
									value="${searchCondition}"> <input type="hidden"
									name="keyword" value="${keyword}"> <input type="hidden"
									name="tpId" value="${vo.tpId }">
								<div class="row">
									<div class="col-md-12 mb-4">
										<div style="margin-bottom: .5em">
											<label for="star">평점</label>
										</div>
										<select class="form-select" name="reviewStar">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
									<div class="col-md-12">
										<textarea class="form-control" placeholder="리뷰를 작성해 주세요."
											name="reviewCon" cols="45" rows="8" required>${vo.reviewCon }</textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12" style="text-align: center;">
							<input type="submit" value="수정" class="btn btn-b"> <a
								href="reviewList.do?prodId=${vo.tpId}" class="btn btn-c">취소</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</main>