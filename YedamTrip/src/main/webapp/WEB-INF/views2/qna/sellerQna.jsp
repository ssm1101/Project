<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<div
			class="card card-body border-0 shadow table-wrapper table-responsive">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="h5">QnA 게시판</h2>
			</div>
			<table style="table-layout: fixed;" class="table table-hover">
				<thead>
					<tr>
						<th class="border-gray-200">문의내용</th>
						<th class="border-gray-200 text-center">회원ID</th>
						<th class="border-gray-200 text-center">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${qnaList }">
						<tr>
							<td style="overflow:hidden;white-space : nowrap;text-overflow: ellipsis;"><span class="fw-normal"><a href="qnaSearch.do?psId=${vo.psId }&pageNum=${pageDTO.cri.pageNum }">${vo.psTitle }</a></span></td>
							<td class="text-center">${vo.mbId }</td>
							<td class="text-center">${vo.psDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div
				class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
				<nav aria-label="Page navigation example">
					<ul id="paging" class="pagination mb-0">
						<c:if test="${pageDTO.prev }">
							<li class="page-item"><a class="page-link" href="sellerQnaForm.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
						</c:if>
						<c:forEach var="item" begin="${pageDTO.startPage }" end="${pageDTO.endPage }">
							<c:choose>
								<c:when test="${pageDTO.cri.pageNum==item }">
									<li class="page-item active"><a class="page-link" href="sellerQnaForm.do?pageNum=${item }">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="sellerQnaForm.do?pageNum=${item }">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageDTO.next }">
							<li class="page-item"><a class="page-link" href="sellerQnaForm.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
