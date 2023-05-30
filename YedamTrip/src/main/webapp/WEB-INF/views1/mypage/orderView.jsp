<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main id="main">
	<section class="contact">
		<div class="container">
			<div class="row">
				<section class="intro-single">
					<div class="container">
						<div class="row">
							<div class="col-md-12 col-lg-8">
								<div class="title-single-box">
									<h1 class="title-single">결제 정보</h1>
									<span class="color-text-a">결제 정보를 확인할 수 있습니다.</span>
								</div>
							</div>
						</div>
					</div>
				</section>

				<div class="row section-t4">
					<div class="col-md-6">
						<div class="col-sm-12">
							<div class="title-box-d">
								<h3 class="title-d">구매 정보</h3>
							</div>
						</div>
						<div class="property-description">
							<div class="col-md-12 mb-3">
								<h5>이름</h5>
								<p>${vo.payName }</p>
							</div>
							<div class="col-md-12 mb-3">
								<h5>연락처</h5>
								<p>${vo.payPhone }</p>
							</div>
							<c:choose>
								<c:when test="${vo.cpId != 0 }">
									<div class="col-md-12 mb-3">
										<h5>사용 쿠폰</h5>
										<p>${cvo.cpName }(${cvo.cpRate }%할인)</p>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>

					<div class="col-md-6">
						<div class="row align-items-center">
							<div class="row mb-4">
								<div class="col-sm-12">
									<div class="title-box-d">
										<h3 class="title-d">상품 정보</h3>
									</div>
								</div>
								<div class="property-description">
									<div class="col-md-12 mb-3">
										<h5>상품명</h5>
										<p>${tvo.tpName }</p>
									</div>
									<div class="col-md-12 mb-3">
										<h5>상품 소개</h5>
										<p>${tvo.tpText }</p>
									</div>
									<div class="col-md-12 mb-3">
										<h5>여행 기간</h5>
										<p>${pvo.prodStart } ~ ${pvo.prodEnd }</p>
									</div>
									<div class="col-md-12 mb-3">
										<h5>인원</h5>
										<p>${vo.payNum }명</p>
									</div>
									<div class="col-md-12 mb-3">
										<h5>결제 금액</h5>
										<p>${vo.payPrice }원</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="section-t4 text-center">
					<a href="orderList.do" class="btn btn-b">목록으로</a>
				</div>
			</div>
		</div>
	</section>
</main>