<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form>
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">상단 노출 목록</h2>
				<div class="table-wrapper table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="border-gray-200 text-center">이미지</th>
								<th class="border-gray-200 text-center">이름</th>
								<th class="border-gray-200 text-center">판매자</th>
								<th class="border-gray-200 text-center">시작일자</th>
								<th class="border-gray-200 text-center">종료일자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="view" items="${TopdisplayView}">

								<tr style="vertical-align: middle;">
								
									<td class="text-center"><img src="attech/${view.tpImg }" alt="" style="width:100px; height:100px;"></td>
									<td class="text-center"><span class="fw-normal">${view.tpName }<!--이름들어와야함--></span></td>
									<td class="text-center"><span class="fw-normal">${view.mbId }<!--판매자들어와야함--></span></td>
									<td class="text-center"><span class="fw-normal">${view.topStart }</span></td>
									<td class="text-center"><span class="fw-normal">${view.topEnd }</span></td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
</div>
