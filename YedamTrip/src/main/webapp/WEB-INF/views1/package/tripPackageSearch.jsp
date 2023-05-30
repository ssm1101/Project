<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">검색결과</h1>
						<span class="color-text-a">예담Trip! 만의 다양한 패키지를 소개합니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>
	
		<section class="property-grid grid">
		<div class="container">
			<div class="row">
				<c:forEach var="vo" items="${tripKeywordSearch }">
					<div class="col-md-4 mb-4">
						<a href="packageItemList.do?tpId=${vo.tpId}">
							<div class="card-box-a card-shadow mb-3">
								<div class="img-box-a">
									<img src="attech/${vo.tpImg }" alt="" class="img-a img-fluid">
								</div>
								<div class="card-overlay">
									<div class="card-overlay-a-content">
										<div class="card-header-a">
											<h2 class="card-title-a">${vo.tpName }</h2>
										</div>
										<div class="card-body-a">
											<div class="price-box d-flex">
												<span class="price-a">￦ ${vo.price }</span>
											</div>
										</div>
										<div class="card-footer-a">
											<ul class="card-info d-flex justify-content-around">
												<li>
													<h4 class="card-info-title">별점</h4> <span>${vo.star }</span>
												</li>
												<li>
													<h4 class="card-info-title">지역</h4> <span>${vo.tpArea }</span>
												</li>
												<li>
													<h4 class="card-info-title">테마</h4> <span>${vo.tpTheme }</span>
												</li>
												<li>
													<h4 class="card-info-title">기간</h4> <span>${vo.tpDate }</span>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</a>
						<div class="row">
							<div class="col-md-6">
								<c:choose>
									<c:when test="${grade==0 }">
										<c:choose>
										    <c:when test="${ vo.heart  == 0}">
										        <button type="button" class="btn btn-b full" onclick="likeItAdd(${vo.tpId })">
										        <i class="bi bi-suit-heart"></i>
										        </button>
										    </c:when>
										    <c:otherwise>
										        <button type="button" class="btn btn-b full" onclick="likeItDelte(${vo.tpId })">
										        <i class="bi bi-suit-heart-fill"></i>
										        </button>
										    </c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<button id="heart${vo.tpId }" type="button" class="btn btn-b full" disabled onclick="likeItAdd(${vo.tpId })">
										<i class="bi bi-suit-heart"></i>
										</button>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="col-md-6">
								<c:choose>
									<c:when test="${grade==0 }">
										<a href="packageReport.do?tpId=${vo.tpId }" class="btn btn-c full"><i
										class="bi bi-megaphone-fill"></i></a>
									</c:when>
									<c:otherwise>
										<a href="packageReport.do?tpId=${vo.tpId }" style="pointer-events: none;" class="btn btn-c full"><i
										class="bi bi-megaphone-fill"></i></a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-sm-12">
				<nav class="pagination-a">
					<ul class="pagination justify-content-end">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1"> <span class="bi bi-chevron-left"></span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item active"><a class="page-link" href="#">2</a>
						</li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item next"><a class="page-link" href="#">
								<span class="bi bi-chevron-right"></span>
						</a></li>
					</ul>
				</nav>
			</div>
	</section>
	
	
</main>

<script>

function likeItAdd(tpId){
	let mbId = '<%=(String) session.getAttribute("id")%>';
	console.log(tpId);
	console.log(mbId);
	
	const likeIt = 'tpId=' + tpId + '&mbId=' + mbId;
	
	fetch("likeItAdd.do", {
		method: 'post',
   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
   		body: likeIt
	})
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		if(result.retCode=="Success"){
   			alert('찜목록에 추가되었습니다.');
   		}else if(result.retCode=="Fail"){
   			alert('처리중 오류 발생.');
   		}else if(result.retCode=="Overlap"){
   			alert('이미 찜목록에 추가되어있는 상품입니다.')
   		}
	})
	
}

function likeItDelte(tpId){
    let mbId = '<%=(String) session.getAttribute("id")%>';
    console.log(tpId);
    console.log(mbId);

    const likeItDel = 'tpId=' + tpId + '&mbId=' + mbId;

    fetch('likeItDelete.do', {
        method: 'post',
   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
   		body: likeItDel
    })
    .then(resolve => resolve.json())
    .then(result => {
        console.log(result);
        if(result.retCode=="Success"){
            alert('찜목록에서 삭제되었습니다.');
        }else if(result.retCode=="Fail"){
            alert('처리중 오류 발생.');
        }
    })
}
</script>