<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main id="main">
	<section class="intro-single">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-8">
					<div class="title-single-box">
						<h1 class="title-single">문의사항</h1>
						<span class="color-text-a">문의 내역을 확인할 수 있습니다.</span>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<div class="col-sm-12">
						<div class="title-box-d">
							<h3 class="title-d">문의 작성</h3>
						</div>
					</div>

					<div class="form-a">
						<div class="row">
							<div class="col-md-12 mb-1">
								<div class="form-group">
									<textarea id="textMessage" class="form-control"
										placeholder="문의 내용을 작성해 주세요." name="message" cols="45"
										rows="8" required></textarea>
								</div>
							</div>

							<c:choose>
								<c:when test="${grade ==2 }">
									<div class="col-md-12 mt-3" style="text-align: right;">
										<button disabled id="addBtn" class="btn btn-b">등록</button>
									</div>
								</c:when>
								<c:otherwise>
									<div class="col-md-12 mt-3" style="text-align: right;">
										<button id="addBtn" class="btn btn-b">등록</button>
									</div>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="news-single nav-arrow-b section-t4 mb-4">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
					<div class="col-sm-12">
						<div class="title-box-d">
							<h3 class="title-d">문의 목록</h3>
						</div>
					</div>

					<c:forEach var="vo" items="${qnaList }">
						<div id="packageBtn" class="row align-items-center">
							<div id="package${vo.psId }" class="col-md-8">
								<div class="col-md-12">
									<h3>Q.</h3>
									<p>${vo.psTitle }</p>
								</div>
								<div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1">
									<h3>A.</h3>
									<p>${vo.psText }</p>
								</div>
							</div>
							<div id="div-btn" class="col-md-4" style="text-align: right;">
								<button id="updateFormBtn${vo.psId }"
									onclick="updateQnaForm(${vo.psId })" class="btn btn-b-n">
									<i class="bi bi-pencil-square"></i>
								</button>
								<button id="updateBtn${vo.psId }"
									onclick="updateQna(${vo.psId })" style="display: none"
									class="btn btn-b-n"><i class="bi bi-check-circle-fill"></i></button>
								<button onclick="deleteQna(${vo.psId })" class="btn btn-b-a">
									<i class="bi bi-trash-fill"></i>
								</button>
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
									href="qnaForm.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
							</c:if>
							<c:forEach var="item" begin="${pageDTO.startPage }"
								end="${pageDTO.endPage }">
								<c:choose>
									<c:when test="${pageDTO.cri.pageNum==item }">
										<li class="page-item active"><a class="page-link"
											href="qnaForm.do?pageNum=${item }">${item }</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="qnaForm.do?pageNum=${item }">${item }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${pageDTO.next }">
								<li class="page-item"><a class="page-link"
									href="qnaForm.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
</main>

<script>
	document.getElementById('addBtn').addEventListener('click', addQna);
	
	function deleteQna(psId){
		console.log(psId);
		
		fetch("qDelete.do", {
			method: 'post',
	   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   		body: 'psId=' + psId
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('문의가 삭제되었습니다.');
	   			location.href = "qnaForm.do";
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.');
	   			location.href = "qnaForm.do";
	   		}
		})
		.catch(reject => console.log(reject))
	}
	
	function updateQnaForm(psId){
		let updateFormBtn = document.getElementById('updateFormBtn'+psId);
		updateFormBtn.style.display = 'none';
		let updateBtn = document.getElementById('updateBtn'+psId);
		updateBtn.style.display = 'inline-block';
		
		let divPackage = updateBtn.parentElement.parentElement;
		console.log(divPackage);
		
		let pTag1 = divPackage.querySelector('div:nth-of-type(1)>div:nth-of-type(1)>p');
		console.log(pTag1);
		
		let pTag2 = divPackage.querySelector('div:nth-of-type(1)>div:nth-of-type(2)>p');
		console.log(pTag2);
		
		let psTitle = pTag1.textContent;
		console.log(psTitle);
		
		let divTag1 = document.createElement('div');
		let newHTag = document.createElement('h3');
		newHTag.innerText = 'Q.';
		let newPTag1 = document.createElement('textarea');
		newPTag1.value = psTitle;
		newPTag1.setAttribute('class','form-control');
		newPTag1.setAttribute('row','4');
		newPTag1.setAttribute('id','newTextArea'+psId);
		divTag1.append(newHTag);
		divTag1.append(newPTag1);
		divPackage.querySelector('div:nth-of-type(1)>div:nth-of-type(1)').replaceWith(divTag1);
		divTag1.setAttribute('class','col-md-12');
		psTitle = document.getElementById('textMessage').value;
	}
	
	function updateQna(psId){
		console.log(psId);
		let psTitle = document.getElementById('newTextArea'+psId).value;
		console.log(psTitle);
		
		let mbId = '${id }';
		console.log(mbId);
		
		fetch("qUpdate.do", {
			method: 'post',
	   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   		body: 'psId=' + psId + '&psTitle=' + psTitle
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('문의가 수정되었습니다.');
	   			location.href = "qnaForm.do";
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.');
	   			location.href = "qnaForm.do";
	   		}
		})
		.catch(reject => console.log(reject))
	}
	
	function addQna(){
		let psTitle = document.getElementById('textMessage').value;
		
		let mbId = '<%=(String) session.getAttribute("id")%>';
		console.log(mbId);
		
		const qna = 'psTitle=' + psTitle + '&mbId=' + mbId;
		
		fetch("qAdd.do", {
			method: 'post',
	   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   		body: qna
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('문의가 등록되었습니다.');
	   			location.href = "qnaForm.do";
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.');
	   			location.href = "qnaForm.do";
	   		}
		})
	}
</script>