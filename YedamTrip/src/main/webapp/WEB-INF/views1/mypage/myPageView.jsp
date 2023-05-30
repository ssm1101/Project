<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/myPageView.js"></script>
<
<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">회원 정보</h1>
						<span class="color-text-a">자신의 정보를 확인하거나 수정할 수 있습니다.</span>
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
						<form onsubmit="return false">
							<div class="col-md-12 col-lg-8">
								<div class="col-md-12 mb-3">
									<h5>이름</h5>
									<p id="myname"></p>
								</div>
								<div class="col-md-12 mb-3">
									<h5>아이디</h5>
									<p id="myid"></p>
								</div>
								<div class="col-md-12 mb-3">
									<h5>연락처</h5>
									<p id="myphone"></p>
								</div>
								<div class="col-md-12 mb-3">
									<h5>이메일</h5>
									<p id="myemail"></p>
								</div>

								<p type="button" id="test" class="color-b">예담Trip을 떠나고
									싶으신가요?</p>
							</div>
						</form>
					</div>
				</div>
			</div>
	</section>

	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">회원탈퇴</h5>
				</div>
				<div class="modal-body">회원탈퇴 하시겠습니까?</div>
				<div class="modal-footer">
					<a class="btn btn-b" href="DeleteU.do">확인</a>
					<button type="button" class="btn btn-c" id="close">취소</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.3.slim.min.js"
		integrity="sha256-ZwqZIVdD3iXNyGHbSYdsmWP//UBokj2FHAxKuSBKDSo="
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			$('#test').click(function() {
				$('#staticBackdrop').modal('show');
			})
			$('#close').click(function() {
				$('#staticBackdrop').modal('hide');
			})
		});
	</script>

	<div class="col-md-12 text-center">
		<a type="button" class="btn btn-b" href="modPageForm.do">수정하기</a> <a
			class="btn btn-c" type="button" href="userMain.do">메인으로</a>
	</div>
</main>