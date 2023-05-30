<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">${trip.tpName }</h1>
						<p class="color-text-a">${trip.tpText }</p>
						<p class="color-text-a tag">
							<span class="color-b"><i class="bi bi-star-fill"></i>${trip.star }</span>
							<span class="color-d">#${trip.tpArea }</span> <span
								class="color-d">#${trip.tpTheme }</span> <span class="color-d">#${trip.tpDate
								}</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="property-single nav-arrow-b">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div id="property-single-carousel">
						<img src="attech/${trip.tpImg }" alt="" style="width: 100%;">
					</div>
					<div
						class="property-single-carousel-pagination carousel-pagination"></div>
				</div>
			</div>

			<div class="row section-t8">
				<div class="col-sm-12">
					<div class="row justify-content-between">
						<div class="col-md-7 col-lg-7 section-md-t3">
							<div class="row">
								<div class="col-sm-12">
									<div class="title-box-d">
										<h3 class="title-d">상세정보</h3>
									</div>
								</div>
							</div>
							<div class="property-description">${prod.prodText }</div>
						</div>
						<div class="col-md-5 col-lg-4">
							<div class="property-summary">
								<div class="row">
									<div class="col-sm-12">
										<div class="title-box-d">
											<h3 class="title-d">인원 선택</h3>
										</div>
									</div>
								</div>
								<div class="summary-list">
									<form action="paymentFrom.do" method="post">
										<input type="hidden" name="tpName" value="${trip.tpName }">
										<input type="hidden" name="tpText" value="${trip.tpText }">
										<input type="hidden" name="prodId" value="${prod.prodId }">
										<input type="hidden" name="prodStart"
											value="${prod.prodStart }"> <input type="hidden"
											name="prodEnd" value="${prod.prodEnd }"> <input
											type="hidden" name="payNum" value="${prod.payNum }">
										<input type="hidden" id="people" name="people" value="1">
										<input type="hidden" id="price" name="price"
											value="${prod.prodPrice}"> <input type="hidden"
											name="publisher" value="${trip.mbId }">
										<div>
											<p>인원수</p>
											<select class="form-control form-select form-control-a"
												id="money" onchange="changeSelection()">
												<c:choose>
													<c:when test="${prod.payNum eq 0 }">
														<option value="">매진되었습니다.</option>
													</c:when>
												</c:choose>
												<c:forEach var="i" begin="1" end="${prod.payNum }">
													<option value=""><c:out value="${i}" /></option>
												</c:forEach>
											</select> <br> <br>
											<div
												class="property-price d-flex justify-content-between align-items-center">
												<p>총 금액</p>
												<h5 class="title-c color-b" style="text-align: right;">
													<span id="h5">${prod.prodPrice }</span>원
												</h5>
											</div>
											<br>
											<div>
												<c:choose>
													<c:when test="${empty id }">
														<button type="button" id="checked" class="btn btn-b full">구매</button>
														<!-- Modal -->
														<div class="modal fade" id="staticBackdrop">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title" id="staticBackdropLabel">로그인</h5>
																	</div>
																	<div class="modal-body">
																		로그인 한 사용자만 구매할 수 있습니다.<br> 로그인 하시겠습니까?
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-c" id="jump">확인</button>
																		<button type="button" class="btn btn-b" id="close">취소</button>
																	</div>
																</div>
															</div>
														</div>

														<script
															src="https://code.jquery.com/jquery-3.6.3.slim.min.js"
															integrity="sha256-ZwqZIVdD3iXNyGHbSYdsmWP//UBokj2FHAxKuSBKDSo="
															crossorigin="anonymous"></script>
														<script>
													$(function () {
														$('#checked').click(function () {
															$('#staticBackdrop').modal('show');
														})
														$('#jump').click(function(){
															$(location).attr("href", "loginForm.do")
														})
														$('#close').click(function(){
															$('#staticBackdrop').modal('hide');																
														})
													});
													</script>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${prod.payNum > 0 }">
																<button type="submit" class="btn btn-b full">결제</button>
															</c:when>
															<c:otherwise>
																<button type="submit" class="btn btn-b full" disabled>결제</button>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</form>
									<script type="text/javascript">
									function changeSelection() {
										let selectedElement = document.getElementById("money");
										let optionVal = selectedElement.options[selectedElement.selectedIndex].text;
										let h5 = document.getElementById("h5");
										h5.innerText = optionVal * ${prod.prodPrice};

										document.getElementById("people").value = optionVal;
										document.getElementById("price").value = optionVal * ${prod.prodPrice};
									}
								</script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1 section-t8">
				<div class="title-box-d">
					<h3 class="title-d">리뷰</h3>
				</div>
				<div class="box-comments">
					<ul class="list-comments">
						<!-- 댓글 -->
						<c:forEach var="vo" items="${reviewList }">
							<li>
								<div class="row">
									<div class="row align-items-center">
										<div class="col-md-8">
											<h4 class="comment-author">@${vo.mbId }</h4>
											<span><i class="bi bi-star-fill"></i> <a>${vo.reviewStar }
											</a> / <a> ${vo.reviewDate }</a></span>
											<p class="comment-description">${vo.reviewCon }</p>
										</div>
										<c:choose>
											<c:when test="${sessionScope.id == vo.mbId }">
												<div class="col-md-4" style="text-align: right;">
													<a
														href="reviewSearch.do?reviewId=${vo.reviewId }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}&pageNum=${pageDTO.cri.pageNum}"
														class="btn btn-b-n" style="color:white"><i class="bi bi-pencil-square"></i></a> <a
														href="deleteReview.do?reviewId=${vo.reviewId }&tpId=${vo.tpId}"
														type="submit" class="btn btn-b-a" style="color:white"><i class="bi bi-trash-fill"></i></a>
												</div>
											</c:when>
											<c:when test="${sessionScope.grade == 1 }">
												<div class="col-md-4" style="text-align: right;">
													<a href="reviewReport.do?reviewId=${vo.reviewId }"
														class="btn btn-b-n" style="color:white;"><i class="bi bi-megaphone-fill"></i></a>
												</div>
											</c:when>
											<c:otherwise>
												<div class="col-md-4" style="text-align: right;">
												<button class="btn btn-b-n" disabled style="color:white"><i class="bi bi-pencil-square"></i></button>
												<button class="btn btn-b-a" disabled style="color:white"><i class="bi bi-trash-fill"></i></button>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</li>
						</c:forEach>
						<!-- 댓글 -->
					</ul>
				</div>
				<div class="form-comments section-t4">
					<div class="title-box-d">
						<h3 class="title-d">리뷰 작성</h3>
					</div>
					<div class="row">
						<div style="display: none">
							<textarea id="mbId">${sessionScope.id}</textarea>
							<textarea id="tpId">${prod.prodId}</textarea>
						</div>
						<div class="col-md-12 mb-3">
							<textarea class="form-control" placeholder="리뷰를 작성해 주세요."
								id="reviewCon" cols="45" rows="8" required>${vo.reviewCon }</textarea>
						</div>
						<div>
							<label for="star">평점</label> <select class="form-select"
								id="reviewStar" style="width: 100px; height: 40px;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select> <br>
						</div>
						<div class="col-md-12" style="text-align: right;">
							<c:choose>
								<c:when test="${sessionScope.id == none }">
									<button disabled type="button" class="btn btn-b">등록</button>
								</c:when>
								<c:otherwise>
									<button type="button" id="btnReview" class="btn btn-b">등록</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="form-comments section-t8">
					<div class="title-box-d">
						<h3 class="title-d">문의하기</h3>
					</div>
					<div class="row">
						<div class="col-md-12 mb-3">
							<textarea id="qnaInput" class="form-control"
								placeholder="문의 내용을 작성해 주세요." name="reviewCon" cols="45"
								rows="8" required></textarea>
						</div>
						<div class="col-md-12" style="text-align: right;">
							<c:choose>
								<c:when test="${grade == 0 }">
									<button type="submit" id="QAdd" class="btn btn-b">등록</button>
								</c:when>
								<c:otherwise>
									<button disabled type="submit" class="btn btn-b">등록</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

			</div>
		</div>
		</div>
	</section>
	<!-- End Property Single-->
</main>
<!-- End #main -->

<script src="js/review.js"></script>

<script>
  	document.getElementById('QAdd').addEventListener('click', qnaAdd);
  	
  	function qnaAdd(){
  		let prodId = ${prod.prodId };
  		console.log(prodId);
  		let mbId = "${id }";
  		console.log(mbId);
  		let psTitle = document.getElementById('qnaInput').value;
  		console.log(psTitle);
  		
  		const qna = "prodId=" + prodId + "&mbId=" + mbId + "&psTitle=" + psTitle;
  		
  		fetch('qAddProduct.do', {
  			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: qna
  		})
  		.then(resolve => resolve.json())
  		.then(result => {
  			console.log(result);
  			if(result.retCode=="Success"){
	   			alert('문의가 등록되었습니다.');
	   			location.href = "reviewList.do?prodId="+prodId;
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.');
	   			location.href = "reviewList.do?prodId="+prodId;
	   		}
  		})
  		.catch(reject => console.log(reject))
  	}
  </script>
}
