<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form action="tripEdit.do" method="post">
			<input type="hidden" name="tpId" value="${trip.tpId }">
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">패키지 등록</h2>
				<div class="row">
					<div class="col-md-12 mb-3">
						<label for="tpName">패키지명</label> <input class="form-control"
							name="tpName" type="text" placeholder="패키지 이름을 입력해 주세요."
							value="${trip.tpName }" required>
					</div>
					<div class="col-md-12 mb-3">
						<label for="tpText">패키지 소개</label>
						<textarea class="form-control" placeholder="패키지 소개를 입력해 주세요."
							name="tpText" rows="4">${trip.tpText }</textarea>
					</div>
					<div class="col-md-12 mb-3">
						<label for="tpImg">패키지 이미지</label> <input class="form-control"
							type="file" name="tpImg" value="${trip.tpImg }">
					</div>
					<div class="col-md-12 mb-3">
						<label for="tpArea">지역</label> <input class="form-control"
							name="tpArea" type="text" placeholder="지역을 입력해 주세요."
							value="${trip.tpArea }">
					</div>
					<div class="col-md-12 mb-3">
						<label for="tpTheme">테마</label> <input class="form-control"
							name="tpTheme" type="text" placeholder="테마를 입력해 주세요."
							value="${trip.tpTheme }">
					</div>
					<div class="col-md-12 mb-3">
						<label for="tpDate">기간</label> <input class="form-control"
							name="tpDate" type="text" placeholder="기간을 입력해 주세요."
							value="${trip.tpDate }">
					</div>
				</div>
			</div>
			<div class="mt-3 mb-4">
				<input type="submit" value="수정"
					class="btn btn-primary mt-2 animate-up-2"> <a
					href="./tripList.do" class="btn btn-secondary mt-2 animate-up-2">취소</a>
			</div>
		</form>
	</div>
</div>