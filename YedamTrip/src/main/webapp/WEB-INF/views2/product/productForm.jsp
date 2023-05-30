<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form action="productAdd.do" method="post">
			<input type="hidden" name="mbId" value="${id }">
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">상품 등록</h2>
				<div class="row">
					<div class="col-md-12 mb-3">
						<label for="tpId">패키지</label> <select name="tpId" id="tpId"
							class="form-select">
							<option value="">패키지를 선택해 주세요.</option>
							<c:forEach var="vo" items="${tripList }">
								<option value="${vo.tpId}">${vo.tpName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-6 mb-3">
						<label for="prodStart">시작기간</label> <input class="form-control"
							name="prodStart" id="prodStart" type="date">
					</div>
					<div class="col-md-6 mb-3">
						<label for="prodEnd">종료기간</label> <input class="form-control"
							name="prodEnd" id="prodEnd" type="date">
					</div>
					<div class="col-md-12 mb-3">
						<label for="prodNum">인원수</label> <input class="form-control"
							name="prodNum" type="number" id="prodNum">
					</div>
					<div class="col-md-12 mb-3">
						<label for="prodPrice">가격</label> <input class="form-control"
							name="prodPrice" type="number" id="prodPrice">
					</div>
					<div class="col-md-12 mb-3">
						<label for="prodText">상세 설명</label>
						<textarea class="form-control" placeholder="상품 상세 설명을 입력해 주세요."
							name="prodText" id="prodText" rows="4"></textarea>
					</div>
				</div>
			</div>
			<div class="mt-3 mb-4">
				<button class="btn btn-primary mt-2 animate-up-2" type="submit">등록</button>
				<a href="./productList.do"
					class="btn btn-secondary mt-2 animate-up-2">취소</a>
			</div>
		</form>
	</div>
</div>
<script>
	window.onload = function() {
		CKEDITOR.replace('prodText')
	}
</script>