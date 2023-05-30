<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">공지사항</h1>
						<span class="color-text-a">예담Trip! 만의 다양한 패키지를 소개합니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<div class="row">
						<div class="col-sm-12">
							<div class="title-box-d">
								<h3 class="title-d">${vo.psTitle }</h3>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">${vo.psText }</div>
					</div>
				</div>
			</div>
	</section>

	<div style="text-align: center;">
		<a href="noticeMainList.do?pageNum=${pageNum }" class="btn btn-b">목록으로</a>
	</div>
</main>