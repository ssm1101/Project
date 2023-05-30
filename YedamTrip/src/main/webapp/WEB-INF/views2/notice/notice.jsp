<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<div
			class="card card-body border-0 shadow table-wrapper table-responsive">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="h5">공지사항</h2>
				<td class="text-center"><a href="noticeAddForm.do"
					class="btn btn-primary">글쓰기</a></td>
			</div>
			<table style="table-layout: fixed;" class="table table-hover">
				<thead>
					<tr>
						<th class="border-gray-200 text-center">제목</th>
						<th class="border-gray-200 text-center">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${noticeList }">
						<tr>
							<td style="overflow:hidden;white-space : nowrap;text-overflow: ellipsis;"><span class="fw-normal"><a href="noticeSearch.do?psId=${vo.psId }&pageNum=${pageDTO.cri.pageNum }">${vo.psTitle }</a></span></td>
							<td class="text-center">${vo.psDate }</td>
						</tr>
					</c:forEach>
					<!--  <tr style="vertical-align: middle;">
						<td><span class="fw-normal"></span></td>
						<td class="text-center"></td>
					</tr> -->
				</tbody>
			</table>
			<div
				class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
				<nav aria-label="Page navigation example">
					<ul id="paging" class="pagination mb-0">
						<c:if test="${pageDTO.prev }">
							<li class="page-item"><a class="page-link" href="notice.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
						</c:if>
						<c:forEach var="item" begin="${pageDTO.startPage }" end="${pageDTO.endPage }">
							<c:choose>
								<c:when test="${pageDTO.cri.pageNum==item }">
									<li class="page-item active"><a class="page-link" href="notice.do?pageNum=${item }">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="notice.do?pageNum=${item }">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageDTO.next }">
							<li class="page-item"><a class="page-link" href="notice.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
						</c:if>
						<!--  
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
						-->
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>

<!--  <script>
	let pageNum = 0;
	fetch("paging.do")
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		console.log(result.page.pageNum);
		
		pageNum = result.page.pageNum;
		let amount = result.page.amount;
		let endPage = result.endPage;
		let startPage = result.startPage;
		let next = result.next;
		let prev = result.prev;
		let total = result.total;
		
		ulTag = document.querySelector('#paging');
		console.log(ulTag);
		
		if(prev){
			let prevLiTag = document.createElement('li');
			let prevATag = document.createElement('a');
			prevATag.innerText = 'prev';
			prevATag.setAttribute('href','notice.do?pageNum='+startPage-1)
			prevLiTag.append(prevATag);
			ulTag.append(prevLiTag);
		}
		for(let i=startPage; i<=endPage ; i++){
			let liTag = document.createElement('li');
			let aTag = document.createElement('a');
			aTag.setAttribute('href','notice.do?pageNum='+i);
			aTag.innerText = i;
			liTag.append(aTag);
			ulTag.append(liTag);
		}
		if(next){
			let prevLiTag = document.createElement('li');
			let prevATag = document.createElement('a');
			prevATag.innerText = 'next';
			prevATag.setAttribute('href','notice.do?pageNum='+parseInt(endPage)+1);
			prevLiTag.append(prevATag);
			ulTag.append(prevLiTag);
		}
		
		console.log(pageNum);
		
		fetch("noticeList.do", {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: 'pageNum=' + pageNum
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			
			let template = document.querySelector('tbody');
			console.log(template);
			for(let i=0; i<result.length;i++){
				
				let trTag = document.createElement('tr');
				let tdTag1 = document.createElement('td');
				let tdTag2 = document.createElement('td');
				let aTag = document.createElement('a');
				aTag.setAttribute('href','noticeSearch.do?psId='+result[i].psId);
				aTag.innerText = result[i].psTitle;
				tdTag2.innerText = result[i].psDate;
				tdTag2.classList.add("text-center");
				
				tdTag1.append(aTag);
				trTag.append(tdTag1);
				trTag.append(tdTag2);
				template.append(trTag);
			}
		})
		.catch(reject => console.log(reject))
		
	})
	.catch(reject => console.log(reject))
	
</script>
-->