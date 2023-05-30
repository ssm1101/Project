<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
	<form name="myFrm" action="updateMember.do">
		<div class="card card-body border-0 shadow mb-4">
			<h2 class="h5 mb-4">판매자 정보</h2>
				<div class="row">
					<div class="col-md-12 mb-3">
						<div>
							<label for="name">이름</label> <input class="form-control"
								id="name" type="text" value="${vo.mbName }">
						</div>
					</div>
					<div class="col-md-12 mb-3">
						<div>
							<label for="id">아이디</label> <input class="form-control" id="id"
								type="text" value="${vo.mbId }">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 mb-3">
						<div>
							<label for="pw">비밀번호 변경</label> <input class="form-control" id="pw" name="mbPw"
								type="password" value="${vo.mbPw }">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<div class="form-group">
							<label for="phone">연락처</label> <input class="form-control"
								id="phone" name="mbPhone" type="text" value="${vo.mbPhone }">
						</div>
					</div>
					<div class="col-md-6 mb-3">
						<div class="form-group">
							<label for="email">이메일</label> <input class="form-control"
								id="email" name="mbEmail" type="email" value="${vo.mbEmail }"
								>
						</div>
					</div>
					<div class="col-mb-6 mb-3">
						<label for="zip">사업자 등록증</label> <input class="form-control"
							id="in" type="file">
					</div>
					<div class="text-primary">
						<span id="drop" style="cursor: pointer;"> 예담Trip을 떠나고
							싶으신가요? </span>
					</div>
				</div>
		</div>
		<div class="mt-3">
			<button class="btn btn-primary mt-2 animate-up-2" type="submit">저장</button>
			<a href="sellerMain.do" class="btn btn-secondary mt-2 animate-up-2">취소</a>
		</div>
		</form>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">제목</h5>
			</div>
			<div class="modal-body">정말 탈퇴하시겠습니까?</div>
			<div class="modal-footer">
				<a href="sellerSecession.do" type="submit" class="btn btn-primary">확인</a>
				<a href="sellerPage.do" class="btn btn-secondary mt-2 animate-up-2">취소</a>
			</div>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.6.3.slim.min.js"
	integrity="sha256-ZwqZIVdD3iXNyGHbSYdsmWP//UBokj2FHAxKuSBKDSo="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		$('#drop').click(function() {
			$('#staticBackdrop').modal('show');
		})
		$('#close').click(function() {
			$('#staticBackdrop').modal('hide');
		})
	});
</script>