<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form name="myFrm" action="couponUpdate.do">
			<div class="card card-body border-0 shadow mb-4">
			<input type="hidden" name="num" value="${vo.cpId }"> 
			<input type="hidden" name="pageNum" value="${pageNum}"> 
			<input type="hidden" name="searchCondition" value="${searchCondition}">
			<input type="hidden" name="keyword" value="${keyword}">

			<h2 class="h5 mb-4">쿠폰 발행</h2>
			<div class="row">
				<div class="col-md-12 mb-3">
					<div>
						<label for="first_name">쿠폰 이름</label>
						<input class="form-control"
							disabled type="text" name="couponName" placeholder="${vo.cpName}" required>
						<input type="hidden" name="couponName" value="${vo.cpName}">
					</div>
				</div>
				<div class="col-md-12 mb-3">
					<div>
						<label for="rate">할인율</label> <select class="form-select"
							name="couponRate">
							<option selected="">할인율을 선택해 주세요.</option>
							<option value="10">10% 할인</option>
							<option value="15">15% 할인</option>
							<option value="20">20% 할인</option>
							<option value="25">25% 할인</option>
							<option value="30">30% 할인</option>
						</select>
					</div>
				</div>
				<div class="col-md-12 mb-3">
					<div>
						<label for="first_name">유효기간</label> <input class="form-control"
							type="number" name="couponEffective"
							placeholder="유효기간(일수)을 입력해 주세요." required>
					</div>
				</div>
			</div>

			<div class="mt-3 mb-4">
				<button class="btn btn-primary mt-2 animate-up-2" type="submit">수정하기</button>
				<!-- <a href="couponUpdate.do" class="btn btn-secondary mt-2 animate-up-2">수정</a> -->
				<a href="couponList.do" class="btn btn-secondary mt-2 animate-up-2">취소</a>
			</div>
			</div>
		</form>
	</div>
</div>


