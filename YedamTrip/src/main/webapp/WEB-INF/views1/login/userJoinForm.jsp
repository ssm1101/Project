<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/userInsert.js"></script>
<script src="js/checkId.js"></script>
<main id="main">
	<!-- ======= Intro Single ======= -->
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">회원가입</h1>
						<span class="color-text-a">예담Trip!에 가입하여 즐거운 여행을 떠나보세요!</span>
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
						<ul class="nav nav-pills-a nav-pills section-t3 mb-4"
							id="pills-tab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								href="userJoinForm.do">
									<h3>일반 사용자</h3>
							</a></li>
							<li class="nav-item"><a class="nav-link"
								href="sellerJoinForm.do">
									<h3>판매자</h3>
							</a></li>
						</ul>
						<div class="tab-content" id="pills-tabContent section-t3 mb-4">
							<div class="tab-pane fade show active" id="muser" role="tabpanel"
								aria-labelledby="pills-video-tab">
								<div class="row">
									<div class="col-md-7">

										<!-- function 충돌 => form비활성화, function활성화 -->
										<form onsubmit="return false">

											<div class="row">
												<div class="col-md-12 mb-3">이름</div>
												<div class="col-md-12 mb-3">
													<div class="form-group">
														<input type="text" id="mname"
															class="form-control form-control-lg form-control-a"
															placeholder="이름을 입력해 주세요." required>
													</div>
												</div>
												<div class="col-md-12 mb-3">아이디</div>
												<div class="col-md-12 mb-3">
													<div class="row">
														<div class="form-group col-md-8">
															<div class="form-group mb-2">
																<input type="text" id="mid"
																	class="form-control form-control-lg form-control-a"
																	placeholder="아이디를 입력해 주세요.">
															</div>
															<div class="form-group">
																<div id="idchk"></div>
															</div>
														</div>
														<div class="form-group col-md-4" style="margin-top: -5px;">
															<div class="col-md-12 text-center">
																<button type="button" class="btn btn-b"
																	onclick="checkId()">중복확인</button>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-12 mb-3">비밀번호</div>
												<div class="col-md-12 mb-3">
													<div class="form-group">
														<input type="password" id="mpw"
															class="form-control form-control-lg form-control-a"
															placeholder="비밀번호를 입력해 주세요.">
													</div>
												</div>
												<div class="col-md-12 mb-3">비밀번호 확인</div>
												<div class="col-md-12 mb-3">
													<div class="form-group">
														<input type="password" id="mmpw"
															class="form-control form-control-lg form-control-a"
															placeholder="비밀번호를 입력해 주세요.">
													</div>
												</div>
												<div class="col-md-12 mb-3">연락처</div>
												<div class="col-md-12 mb-3">
													<div class="form-group">
														<input type="text" id="mphone"
															class="form-control form-control-lg form-control-a"
															placeholder="010-0000-0000">
													</div>
												</div>
												<div class="col-md-12 mb-3">이메일</div>
												<div class="col-md-12 mb-3">
													<div class="form-group">
														<input type="email" id="memail"
															class="form-control form-control-lg form-control-a"
															placeholder="이메일을 입력해 주세요.">
													</div>
												</div>
												<div class="col-md-12 text-center">
													<button type="submit" class="btn btn-b"
														onclick="userInsert()">가입하기</button>
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
				</div>
			</div>
		</div>
	</section>
	<!-- End Contact Single-->
</main>
<!-- End #main -->





