<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">${trip.tpName }</h1>
						<span class="color-text-a">${trip.tpText }</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-grid grid">
		<div class="container">
			<div class="row">
				<c:forEach var="vo" items="${prodList }">
					<div class="col-md-4">
						<a href="reviewList.do?prodId=${vo.prodId }">
							<div class="card-box-b card-shadow news-box">
								<div class="img-box-b">
									<img src="attech/${trip.tpImg }" alt="" class="img-b img-fluid">
								</div>
								<div class="card-overlay">
									<div class="card-header-b">
										<div class="card-category-b">
											<span class="category-b">${vo.payNum }명</span>
										</div>
										<div class="card-title-b">
											<h2 class="title-2 color-w">${vo.tpName }</h2>
										</div>
										<div class="card-date">
											<span class="date-b">${vo.prodStart } ~ ${vo.prodEnd }</span>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</main>