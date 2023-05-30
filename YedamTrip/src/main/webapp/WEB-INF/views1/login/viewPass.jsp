<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<main id="main">

	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">비밀번호확인</h1>
						<span class="color-text-a">비밀번호기억안나죠?!열받죠?</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-grid grid">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-md-7">
							<form action="forms/contact.php" method="post" role="form"
								class="php-email-form">
								<div class="col-md-12 mb-3">비밀번호</div>
								<div class="col-md-12 mb-3">
									<p class="color-b">${pw	}</p>
								</div>
								<div class="col-md-12 text-center">
									<!-- 
									<button type="button" class="btn btn-c" href="userMain.do">메인</button> -->
									<a class="btn btn-c" href="userMain.do">메인</a>
								</div>
							</form>
						</div>
						<div class="col-md-5 section-md-t3">
							<div class="swiper-slide carousel-item-a intro-item bg-image"
								style="background-image: url(assets/img/slide-2.jpg)"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
 </main> 