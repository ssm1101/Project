<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="contact">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">찜 목록</h1>
						<span class="color-text-a">마음에 들어한 패키지를 확인할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<c:forEach var="vo" items="${likeItList }">
						<div class="post-content color-text-a mb-4">
							<div class="row align-items-center">
								<div class="col-md-8">
									<div class="card-title-b mb-4">
										<h2 class="title-2">
											<a href="packageItemList.do?tpId=${vo.tpId }">${vo.tpName }</a>
										</h2>
									</div>
									<div>
										<p>${vo.tpText }</p>
									</div>
								</div>

								<div class="col-md-4" style="text-align: right">
									<button class="btn btn-b-a" onclick="likeItDelete(${vo.tpId })">
										<i class="bi bi-suit-heart-fill"></i>
									</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<nav class="pagination-a">
						<ul class="pagination justify-content-end">
							<c:if test="${pageDTO.prev }">
								<li class="page-item"><a class="page-link"
									href="likeItListForm.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
							</c:if>
							<c:forEach var="item" begin="${pageDTO.startPage }"
								end="${pageDTO.endPage }">
								<c:choose>
									<c:when test="${pageDTO.cri.pageNum==item }">
										<li class="page-item active"><a class="page-link"
											href="likeItListForm.do?pageNum=${item }">${item }</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="likeItListForm.do?pageNum=${item }">${item }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageDTO.next }">
								<li class="page-item"><a class="page-link"
									href="likeItListForm.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
</section>

<script>
let pageNum = ${pageDTO.cri.pageNum };

function likeItDelete(tpId){
	let mbId = '<%=(String) session.getAttribute("id")%>';
	console.log(tpId);
	console.log(mbId);
	
	const likeIt = 'tpId=' + tpId + '&mbId=' + mbId;6
	
	fetch("likeItDelete.do", {
		method: 'post',
   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
   		body: likeIt
	})
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		if(result.retCode=="Success"){
   			alert('찜목록에서 삭제되었습니다.');
   			location.href = "likeItListForm.do?pageNum="+pageNum;
   		}else if(result.retCode=="Fail"){
   			alert('처리중 오류 발생.');
   		}
	})
}
</script>