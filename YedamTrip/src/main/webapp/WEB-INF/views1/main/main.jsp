<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ======= Intro Section ======= -->
<div class="intro intro-carousel swiper position-relative">
	<div class="swiper-wrapper">
		<c:forEach var="tvo" items="${TopdisplayView}">
			<div class="swiper-slide carousel-item-a intro-item bg-image"
				style="background-image: url(attech/${tvo.tpImg})">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-12">
									<div class="intro-body">
										<p class="intro-title-top">
											${tvo.tpArea} <br> ${tvo.tpTheme}
										</p>
										<h1 class="intro-title mb-4 ">
											<span class="color-b">${tvo.tpDate} </span> <br>
											${tvo.tpName}
										</h1>
										<p class="intro-subtitle intro-price">
											<a href="packageItemList.do?tpId=${tvo.tpId}"><span class="price-a">확인하러가기!</span></a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="swiper-pagination"></div>
</div>
<!-- End Intro Section -->

<main id="main">
	<!-- ======= Latest Properties Section ======= -->
	<section class="section-property section-t8">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a">추천 패키지</h2>
						</div>
						<div class="title-link">
							<a href="packageList.do">더보기 <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div id="property-carousel" class="swiper">
				<div class="swiper-wrapper">
						<c:forEach var="vo" items="${tripList }">
						<div class="carousel-item-b swiper-slide">
							<a href="packageItemList.do?tpId=${vo.tpId}">
								<div class="card-box-a card-shadow mb-3">
									<div class="img-box-a">
										<img src="attech/${vo.tpImg }" alt="" class="img-a img-fluid">
									</div>
									<div class="card-overlay">
										<div class="card-overlay-a-content">
											<div class="card-header-a">
												<h2 class="card-title-a">${vo.tpName }</h2>
											</div>
											<div class="card-body-a">
												<div class="price-box d-flex">
													<span class="price-a">￦ ${vo.price }</span>
												</div>
											</div>
											<div class="card-footer-a">
												<ul class="card-info d-flex justify-content-around">
													<li>
														<h4 class="card-info-title">별점</h4> <span>${vo.star }</span>
													</li>
													<li>
														<h4 class="card-info-title">지역</h4> <span>${vo.tpArea }</span>
													</li>
													<li>
														<h4 class="card-info-title">테마</h4> <span>${vo.tpTheme }</span>
													</li>
													<li>
														<h4 class="card-info-title">기간</h4> <span>${vo.tpDate }</span>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="propery-carousel-pagination carousel-pagination"></div>

		</div>
	</section>
	<!-- End Latest Properties Section -->

	<!-- ======= Services Section ======= -->
	<section class="section-services section-t8"
		style="margin-bottom: 10rem;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a">공지사항</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 box-border">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div>
								<h3 id="noticeHTag-1" class="">Lifestyle</h3>
							</div>
						</div>
						<div class="card-body-c">
							<p id="noticePTag-1" class="content-c">Sed porttitor lectus nibh. Cras
								ultricies ligula sed magna dictum porta. Praesent sapien massa,
								convallis a pellentesque nec, egestas non nisi.</p>
						</div>
						<div class="card-footer-c">
							<a id="noticeATag-1" href="#" class="link-c link-icon">더보기 <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 box-border">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-title-c align-self-center">
								<h3 id="noticeHTag-2" class="">Loans</h3>
							</div>
						</div>
						<div class="card-body-c">
							<p id="noticePTag-2" class="content-c">Nulla porttitor accumsan tincidunt.
								Curabitur aliquet quam id dui posuere blandit. Mauris blandit
								aliquet elit, eget tincidunt nibh pulvinar a.</p>
						</div>
						<div class="card-footer-c">
							<a id="noticeATag-2" href="#" class="link-c link-icon">더보기 <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 box-border">
					<div class="card-box-c foo">
						<div class="card-header-c d-flex">
							<div class="card-title-c align-self-center">
								<h3 id="noticeHTag-3" class="">Sell</h3>
							</div>
						</div>
						<div class="card-body-c">
							<p id="noticePTag-3" class="content-c">Sed porttitor lectus nibh. Cras
								ultricies ligula sed magna dictum porta. Praesent sapien massa,
								convallis a pellentesque nec, egestas non nisi.</p>
						</div>
						<div class="card-footer-c">
							<a id="noticeATag-3" href="#" class="link-c link-icon">더보기 <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Services Section -->
</main>
<!-- End #main -->

<script>
  fetch("noticeMain.do")
  .then(resolve => resolve.json())
  .then(result => {
	  console.log(result);
	  let noticeHTag1 = document.getElementById('noticeHTag-1');
	  noticeHTag1.innerText = result[0].psTitle;
	  let noticePTag1 = document.getElementById('noticePTag-1');
	  noticePTag1.innerText = result[0].psText;
	  let noticeATag1 = document.getElementById('noticeATag-1');
	  noticeATag1.setAttribute('href','noticeMainSearch.do?psId='+result[0].psId);
	  
	  let noticeHTag2 = document.getElementById('noticeHTag-2');
	  noticeHTag2.innerText = result[1].psTitle;
	  let noticePTag2 = document.getElementById('noticePTag-2');
	  noticePTag2.innerText = result[1].psText;
	  let noticeATag2 = document.getElementById('noticeATag-2');
	  noticeATag2.setAttribute('href','noticeMainSearch.do?psId='+result[1].psId);
	  
	  let noticeHTag3 = document.getElementById('noticeHTag-3');
	  noticeHTag3.innerText = result[2].psTitle;
	  let noticePTag3 = document.getElementById('noticePTag-3');
	  noticePTag3.innerText = result[2].psText;
	  let noticeATag3 = document.getElementById('noticeATag-3');
	  noticeATag3.setAttribute('href','noticeMainSearch.do?psId='+result[2].psId);
	  
  })
</script>