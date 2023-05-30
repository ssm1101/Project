<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-12 col-xl-8">
		<div
			class="card card-body border-0 shadow table-wrapper table-responsive">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="h5">패키지 목록</h2>
				<td class="text-center"><a href="tripFrom.do"
					class="btn btn-primary">패키지 등록</a></td>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="border-gray-200">등록 패키지 <small><span></span>건</small>
						</th>
						<th class="border-gray-200 text-center">기타</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${tripList }">
						<tr style="vertical-align: middle;">
							<td><span class="fw-normal">${vo.tpName }</span></td>
							<td class="text-center">							
								<button onclick="topdispermiss(${vo.tpId})" class="btn btn-tertiary">상단노출</button>
								<a href="tripFormEdit.do?tpId=${vo.tpId }" class="btn btn-primary">수정</a>
								<a href="tripDel.do?tpId=${vo.tpId }" class="btn btn-secondary">삭제</a>
							</td>
						</tr>
						
						<script>

							function topdispermiss(num)  {
								
								const xhtp = new XMLHttpRequest();
								xhtp.open('get','topdisplayInsert.do?tpId='+num);
								xhtp.send();	
								alert('신청완료!');	
								
							}

						</script>
												
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>


