<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-12 col-xl-8">
		<div
			class="card card-body border-0 shadow table-wrapper table-responsive">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="h5">상품 목록</h2>
				<td class="text-center"><a href="productForm.do"
					class="btn btn-primary">상품 등록</a></td>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="border-gray-200">등록 상품</th>
						<th class="border-gray-200 text-center">시작 날짜</th>
						<th class="border-gray-200 text-center">끝 날짜</th>
						<th class="border-gray-200 text-center">기타</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${productList }">
						<tr style="vertical-align: middle;">
							<td><span class="fw-normal">${vo.tpName }</span></td>
							<td class="text-center"><span class="fw-normal">${vo.prodStart }</span></td>
							<td class="text-center"><span class="fw-normal">${vo.prodEnd }</span></td>
							<td class="text-center">
							<a href="productEditForm.do?prodId=${vo.prodId }" class="btn btn-primary">수정</a>
							<a href="productDel.do?prodId=${vo.prodId }" class="btn btn-secondary">삭제</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>