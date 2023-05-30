<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">공지사항</h1>
						<span class="color-text-a">예담Trip!의 공지사항이 게시됩니다.</span>
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
						<div class="col-sm-12">
							<table style="table-layout: fixed;" class="table table-hover">
								<colgroup>
									<col />
									<col style="width: 200px" />
								</colgroup>
								<thead>
									<tr>
										<th class="border-gray-200 text-center">제목</th>
										<th class="border-gray-200 text-center">작성일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="vo" items="${noticeList }">
										<tr>
											<td
												style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;"><a
												href="noticeMainSearch.do?psId=${vo.psId }&pageNum=${pageDTO.cri.pageNum }"
												class="fw-normal" style="display: block;">${vo.psTitle }</a></td>
											<td class="text-center">${vo.psDate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<nav aria-label="Page navigation example" class="pagination-a">
				<ul id="paging" class="pagination justify-content-end">
					<c:if test="${pageDTO.prev }">
						<li class="page-item"><a class="page-link"
							href="noticeMainList.do?pageNum=${pageDTO.startPage-1 }"><span
								class="bi bi-chevron-left"></a></li>
					</c:if>
					<c:forEach var="item" begin="${pageDTO.startPage }"
						end="${pageDTO.endPage }">
						<c:choose>
							<c:when test="${pageDTO.cri.pageNum==item }">
								<li class="page-item active"><a class="page-link"
									href="noticeMainList.do?pageNum=${item }">${item }</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="noticeMainList.do?pageNum=${item }">${item }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pageDTO.next }">
						<li class="page-item"><a class="page-link"
							href="noticeMainList.do?pageNum=${pageDTO.endPage+1 }"><span
								class="bi bi-chevron-right"></a></li>
						<li class="page-item next"><a class="page-link" href="#">
					</c:if>
				</ul>
			</nav>
			</section>
</main>