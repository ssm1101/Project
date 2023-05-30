<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/sellerInsert.js"></script>
<div class="row">
	
	<div class="col-12 col-xl-8">
		
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">판매자 관리</h2>
				<div class="table-wrapper table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="border-gray-200 text-center">이름</th>
								<th class="border-gray-200 text-center">아이디</th>
								<th class="border-gray-200 text-center">연락처</th>
								<th class="border-gray-200 text-center">이메일</th>
								<th class="border-gray-200 text-center">사업자등록증</th>
								<th class="border-gray-200 text-center">승인완료여부</th>
								<th class="border-gray-200 text-center">승인/삭제</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo" items="${sellerList }">
								<tr style="vertical-align: middle;">
									<td class="text-center">${vo.mbName }</td>
									<td class="text-center">${vo.mbId }</td>
									<td class="text-center">${vo.mbPhone }</td>
									<td class="text-center">${vo.mbEmail }</td>
									<td class="text-center">${vo.bsCode }</td>
									<c:choose>
										
										<c:when test="${vo.sellPermiss == 1}">
											<td class="text-center">승인완료</td>
											<td class="text-center">
												<button type="button" class="btn btn-primary mt-2 animate-up-2" disabled>승인</button>
												<a href="sellerDelete.do?mbId=${vo.mbId}" type="button" class="btn btn-secondary mt-2 animate-up-2" onclick="alert('삭제완료')">삭제</a>
											</td>
										</c:when>
										
										<c:otherwise>
											<td class="text-center">미승인</td>
											<td class="text-center">
												<a href="sellerPermiss.do?mbId=${vo.mbId}" type="button" class="btn btn-primary mt-2 animate-up-2" onclick="alert('승인완료!')">승인</a>
												<a href="sellerDelete.do?mbId=${vo.mbId}" type="button" class="btn btn-secondary mt-2 animate-up-2" onclick="alert('삭제완료')">삭제</a>
											</td>
										</c:otherwise>
																			
									</c:choose>
									

									<!--  
									<button type="submit" class="btn btn-b" onclick="sellerInsert()">승인</button>
									<button type="submit" class="btn btn-b" onclick="sellerDelete.do">삭제</button>
									-->
								</tr>
							</c:forEach>		
							
						</tbody>
					</table>
				</div>
				<div
					class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination mb-0">
							<c:if test="${pageDTO.prev }">
								<li class="page-item"><a class="page-link"
									href="userList.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
							</c:if>
							<c:forEach var="item" begin="${pageDTO.startPage }"
								end="${pageDTO.endPage }">
								<c:choose>
									<c:when test="${pageDTO.cri.pageNum==item }">
										<li class="page-item active"><a class="page-link"
											href="notice.do?pageNum=${item }">${item }</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="notice.do?pageNum=${item }">${item }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageDTO.next }">
								<li class="page-item"><a class="page-link"
									href="notice.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
	</div>
</div>