<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row mb-4">
	<div class="col-12 col-xl-8">
		<div class="card border-0 shadow">
			<div class="card-header">
				<div class="row align-items-center">
					<div class="col">
						<h2 class="fs-5 fw-bold mb-0">한눈에 보기</h2>
					</div>

				</div>
			</div>
			<div class="table-responsive" style="overflow-y: hidden;">
				<div style="padding: 1rem;">
					<div id="chart_div"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row mb-4">
	<div class="col-12 col-xl-8">
		<div class="card border-0 shadow">
			<div class="card-header">
				<div class="row align-items-center">
					<div class="col">
						<h2 class="fs-5 fw-bold mb-0">전체 조회</h2>
					</div>

				</div>
			</div>
			<div class="table-responsive">
				<table class="table align-items-center table-flush">
					<thead class="thead-light">
						<tr>
							<th class="border-bottom" scope="col">패키지 이름</th>
							<th class="border-bottom" scope="col">판매 개수</th>
							<th class="border-bottom" scope="col">판매 수익</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${psList }">
							<tr>
								<th class="text-gray-900" scope="row">${vo.tpName }</th>
								<td class="text-gray-500">${vo.count }</td>
								<td class="fw-bolder text-primary">￦ ${vo.price }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script src="js/sellerChart.js"></script>