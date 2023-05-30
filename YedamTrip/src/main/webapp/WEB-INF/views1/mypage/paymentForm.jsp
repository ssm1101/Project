<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">예약</h1>
						<p class="color-text-a">결제 전 예약 정보를 확인해 주세요.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="property-single nav-arrow-b">
		<form action="paymentAdd.do">
			<div class="container">
				<div class="row section-t8">
					<div class="col-sm-12">
						<div class="row justify-content-between">
							<div class="col-md-7 col-lg-7">
								<div class="col-sm-12">
									<div class="title-box-d">
										<h3 class="title-d">구매 정보</h3>
									</div>
								</div>
								<div class="property-description">
									<div class="col-md-12 mb-3">
										<h5>이름</h5>
										<input name="mbName" type="text"
											class="form-control form-control-lg form-control-a"
											value="${vo.mbName }" required>
									</div>
									<div class="col-md-12 mb-3">
										<h5>연락처</h5>
										<input name="mbPhone" type="text"
											class="form-control form-control-lg form-control-a"
											value="${vo.mbPhone }" required>
									</div>
									<div class="col-md-12 mb-3">
										<h5>사용 쿠폰</h5>
										<select name="ucpId" id="ucpId"
											class="form-control form-select form-control-a">
											<option value="0">사용할 쿠폰을 선택해 주세요.</option>
											<c:forEach var="cvo" items="${cvo }">
												<c:choose>
													<c:when test="${cvo.cpStatus == 'O' }">
														<option state="${cvo.cpRate }" value="${cvo.ucpId }">[사용가능]
															${cvo.cpName } (${cvo.cpRate }% 할인)</option>
													</c:when>
													<c:otherwise>
														<option state="${cvo.cpRate }" value="${cvo.ucpId }"
															disabled>[사용불가] ${cvo.cpName } (${cvo.cpRate }%
															할인)</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-5 col-lg-4">
								<div class="property-summary">
									<div class="row">
										<div class="col-sm-12">
											<div class="title-box-d">
												<h3 class="title-d">결제 정보</h3>
											</div>
										</div>
									</div>
									<div class="summary-list">
										<div class="col-md-12 mb-3">
											<h5>상품명</h5>
											<p>${tpName }</p>
										</div>
										<div class="col-md-12 mb-3">
											<h5>상품 소개</h5>
											<p>${tpText }</p>
										</div>
										<div class="col-md-12 mb-3">
											<h5>여행 기간</h5>
											<p>${prodStart }~${prodEnd }</p>
										</div>
										<div class="col-md-12 mb-3">
											<h5>인원</h5>
											<p>${people }명</p>
										</div>
										<div
											class="property-price d-flex justify-content-between align-items-center">
											<p>총 금액</p>
											<h5 class="title-c color-b" style="text-align: right;">
												<span id="h5">${price }</span>원
											</h5>
										</div>
										<br>
										<div>
											<input type="hidden" name="prodId" value="${prodId }">
											<input type="hidden" name="payPrice" value="${price }">
											<input type="hidden" name="people" value="${people }">
											<input type="hidden" name="mbId" value="${id }"> <input
												type="hidden" name="payNum" value="${payNum }">
											<button type="submit" class="btn btn-b full">결제</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</main>
<script src="https://code.jquery.com/jquery-3.6.3.slim.min.js"
	integrity="sha256-ZwqZIVdD3iXNyGHbSYdsmWP//UBokj2FHAxKuSBKDSo="
	crossorigin="anonymous"></script>
<script>
$("#ucpId").change(function(){
	var optionVal = $('option:selected',this).attr('state');
	var price = ${price } - (${price } * optionVal * 0.01);
	console.log(optionVal);
	$('#h5').text(price);
})
</script>