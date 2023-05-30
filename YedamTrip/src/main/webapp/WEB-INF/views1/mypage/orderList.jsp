<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">구매 목록</h1>
						<span class="color-text-a">구매 내역을 확인할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<c:forEach var="vo" items="${paymentList }">
						<div class="post-content color-text-a mb-4">
							<div class="row align-items-center">
								<div class="col-md-8">
									<a href="orderView.do?payId=${vo.payId }">
										<div class="card-title-b mb-4">
											<h2 class="title-2">${vo.tpName }</h2>
										</div>
										<div>
											<p>${vo.tpText }</p>
										</div>
									</a>
								</div>

								<div class="col-md-4" style="text-align: right">
									<a href="orderDel.do?payId=${vo.payId }" class="btn btn-b-a"><i
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