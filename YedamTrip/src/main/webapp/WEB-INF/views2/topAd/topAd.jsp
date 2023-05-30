<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form action="topdisplayList.do" method="post">
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">상단 노출 신청 목록</h2>
				<div class="table-wrapper table-responsive">

					<table class="table table-hover">
						<thead>
							<tr>
								<th class="border-gray-200 text-center">이미지</th>
								<th class="border-gray-200 text-center">이름</th>
								<th class="border-gray-200 text-center">판매자</th>
								<th class="border-gray-200 text-center">기타</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo" items="${TopdisplayList}">
								<tr style="vertical-align: middle;">
									<td class="text-center"><img src="attech/${vo.tpImg }" alt="" style="width:100px; height:100px;"></td>
									<td class="text-center"><span class="fw-normal">${vo.tpName }	<!--이름들어와야함--></span></td>
									<td class="text-center"><span class="fw-normal">${vo.mbId }	<!--판매자들어와야함--></span></td>
									<td class="text-center">
										<a href="topdisplayPermiss.do?num=${vo.tpId}" type="button" class="btn btn-primary mt-2 animate-up-2" onclick="alert('승인완료! 상단 노출 목록에서 확인 가능합니다.')">승인</a>
										<a href="topdisplayDelete.do?num=${vo.tpId}" type="button" class="btn btn-secondary mt-2 animate-up-2" onclick="alert('상단 노출 거부 완료!')">거부</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>				

				<div class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
					<ul class="pagination mb-0">

						<c:if test="${pageDTO.prev }">
							<li class="page-item"><a class="page-link" href="topdisplayList.do?pageNum=${pageDTO.startPage-1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">Previous</a></li>
						</c:if>


						<c:forEach var="item" begin="${pageDTO.startPage }"
							end="${pageDTO.endPage }">
							<c:choose>
								<c:when test="${pageDTO.cri.pageNum == item }">
									<li class="page-item active"><a class="page-link" href="topdisplayList.do?pageNum=${item}&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="topdisplayList.do?pageNum=${item}&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pageDTO.next }">
							<li class="page-item"><a class="page-link" href="topdisplayList.do?pageNum=${pageDTO.endPage+1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</form>
	</div>
</div>