<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/findPass.js"></script>

<main id="main">
	<!-- ======= Intro Single ======= -->
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">비밀번호 찾기</h1>
						<span class="color-text-a">비밀번호를 찾기 위해 아래의 정보를 작성해 주세요.</span>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Intro Single-->

	<!-- ======= Contact Single ======= -->
	<section class="contact">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-md-7">
							<form action="findPass.do">
								<div class="col-md-12 mb-3">아이디</div>
								<div class="row">
									<div class="col-md-12 mb-3">
										<div class="form-group">
											<input type="text" name="mbId" id="id"
												class="form-control form-control-lg form-control-a"
												placeholder="아이디를 입력해 주세요." required>
										</div>
									</div>
									<div class="col-md-12 mb-3">연락처</div>
									<div class="col-md-12 mb-3">
										<div class="form-group">
											<input name="mbPhone" type="text" id="phone"
												class="form-control form-control-lg form-control-a"
												placeholder="000-0000-0000" required>
										</div>
									</div>
									<div class="col-md-12 text-center">
										<button type="submit" class="btn btn-b" >찾기</button>
									</div>
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
	<!-- End Contact Single-->
</main>
<!-- End #main -->

