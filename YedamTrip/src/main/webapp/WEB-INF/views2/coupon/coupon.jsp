<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<form action="couponInsert.do" method="post">
			<div class="card card-body border-0 shadow mb-4">
				<h2 class="h5 mb-4">쿠폰 발행</h2>
				<div class="row">
					<div class="col-md-12 mb-3">
						<div>
							<label for="first_name">쿠폰 이름</label> <input class="form-control"
								type="text" name="couponName" placeholder="이름을 입력해 주세요."
								required>
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
					<button class="btn btn-primary mt-2 animate-up-2" type="submit" >등록하기</button>
				</div>		
			</div>
		</form>
	</div>
	
	
	
	<div class="col-12 col-xl-8">

		<form action="couponList.do" method="post" name="myFrm">
			<div
				class="card card-body border-0 shadow table-wrapper table-responsive">
				<h2 class="h5 mb-4">쿠폰 목록</h2>
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="border-gray-200 text-center"><input type="checkbox" name="check" value="selectall" onclick="selectAll(this)"></th>
							
							<th class="border-gray-200">발행 쿠폰 <!--  <small>1건</small> -->
							</th>
							<th class="border-gray-200">할인율</th>
							<th class="border-gray-200">유효기간</th>
							<th class="border-gray-200">등록자</th>
							<th class="border-gray-200 text-center">수정/삭제</th>
							
						</tr>
					</thead>
					<tbody>
						<!-- 쿠폰 -->
						<c:forEach var="vo" items="${CouponList}">
							<tr style="vertical-align: middle;">
								<c:choose>
									<c:when test="${vo.cpPublisher == LoginId }">
										<td class="text-center"><input type="checkbox" name="check" value="${vo.cpId }"/></td>
										
										<td><span class="fw-normal">${vo.cpName }<!-- 쿠폰이름 --></span></td>
										<td><span class="fw-normal">${vo.cpRate } %<!-- 쿠폰할인율 --></span></td>
										<td><span class="fw-normal">${vo.cpExpire }<!-- 쿠폰유효기간 --></span></td>
										<td><span class="fw-normal">${vo.cpPublisher }<!-- 쿠폰유효기간 --></span></td>
										
										<td class="text-center">
											<a href="couponSearch.do?num=${vo.cpId}&cpName=${vo.cpName}&cpRate=${vo.cpRate}&cpExpire=${vo.cpExpire}" type="button" class="btn btn-primary animate-up-2">수정</a> 
											<a href="couponDelete.do?num=${vo.cpId}" type="button" class="btn btn-secondary animate-up-2">삭제</a>
											<!--  	<input type="button" value="삭제" class="btn btn-secondary" id="num=${vo.cpId}" onclick="delFunc()"> -->											
										</td>									
									</c:when>
								</c:choose>

							</tr>
						</c:forEach>
					</tbody>				
				</table>
				
				

<!-- 		 	<p>${pageDTO}</p>  -->


				<div class="mt-3 mb-4">
					<button onclick="checkedboxDelete()" class="btn btn-primary mt-2 animate-up-2">선택삭제</button>
				</div>				
				
<!--  				
				<div class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
					<ul class="pagination mb-0">

						<c:if test="${pageDTO.prev }">
							<li class="page-item"><a class="page-link" href="couponList.do?pageNum=${pageDTO.startPage-1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">Previous</a></li>
						</c:if>


						<c:forEach var="item" begin="${pageDTO.startPage }"
							end="${pageDTO.endPage }">
							<c:choose>
								<c:when test="${pageDTO.cri.pageNum == item }">
									<li class="page-item active"><a class="page-link" href="couponList.do?pageNum=${item}&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="couponList.do?pageNum=${item}&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pageDTO.next }">
							<li class="page-item"><a class="page-link" href="couponList.do?pageNum=${pageDTO.endPage+1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">Next</a></li>
						</c:if>
					</ul>
				</div>
				
-->

				<!--   				<div
					class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination mb-0">
							<li class="page-item"><a class="page-link" href="#">Previous</a>
							</li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item active"><a class="page-link" href="#">2</a>
							</li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">4</a></li>
							<li class="page-item"><a class="page-link" href="#">5</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</nav>
				</div> -->
			</div>
		</form>
	</div>
</div>

<script>
function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('check');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}

function checkedboxDelete()  {
	  // 선택된 목록 가져오기
	  const query = 'input[name="check"]:checked';	  
	  const selectedEls = 
	      document.querySelectorAll(query);
	  
	  // 선택된 목록에서 value 찾기
	  let result = '';
	  selectedEls.forEach((el) => {
		  
		 console.log(el.value);
	 	 const xhtp = new XMLHttpRequest();
	 	 xhtp.open('get','couponDelete.do?num='+el.value);
	 	 xhtp.send();	
	    
	  }); 
	  
	  alert('삭제완료');
	  
}

</script>


