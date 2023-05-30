<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-12 col-xl-8">
		<div class="card card-body border-0 shadow">
			<div class="d-flex justify-content-between align-items-center mb-4">
				<h2 class="h5">신고 관리</h2>
			</div>
			<div id="reportTable"></div>
			<!--
			<table class="table">
				<thead>
					<tr>
						<th class="border-gray-200">등록 상품 <small>1건</small>
						</th>
						<th class="border-gray-200 text-center">기타</th>
					</tr>
				</thead>
				<tbody>
					<tr style="vertical-align: middle;">
						<td style="white-space: normal;"><b>서울, 도심 속 야경</b><br>
							취소도 안해주고 쓰레기에요... 취소도 안해주고 쓰레기에요... 취소도 안해주고 쓰레기에요... 취소도 안해주고
							쓰레기에요... 취소도 안해주고 쓰레기에요... 취소도 안해주고 쓰레기에요...</td>
						<td rowspan="2" class="text-center">
							<button type="button" class="btn btn-primary">요청삭제</button>
							<button type="button" class="btn btn-secondary">상품삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
			-->
			<!--
			<div
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
			</div>
			-->
			<div
				class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-center">
				<nav aria-label="Page navigation example">
					<ul id="paging" class="pagination mb-0">
						<c:if test="${pageDTO.prev }">
							<li class="page-item"><a class="page-link" href="packageReportListForm.do?pageNum=${pageDTO.startPage-1 }">Previous</a></li>
						</c:if>
						<c:forEach var="item" begin="${pageDTO.startPage }" end="${pageDTO.endPage }">
							<c:choose>
								<c:when test="${pageDTO.cri.pageNum==item }">
									<li class="page-item active"><a class="page-link" href="packageReportListForm.do?pageNum=${item }">${item }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="packageReportListForm.do?pageNum=${item }">${item }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageDTO.next }">
							<li class="page-item"><a class="page-link" href="packageReportListForm.do?pageNum=${pageDTO.endPage+1 }">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			
		</div>
	</div>
</div>
<script>
	let titles=['등록 신고','기타'];
	let total = ${pageDTO.total }
	console.log(total);
	function makeTr(report={}){
		tr = document.createElement('tr');
		td = document.createElement('td');
		tr.setAttribute('style',"vertical-align: middle;");
		
		let tpName = report.tpName;
		let tpId = report.tpId;
		let reportCon = report.reportCon;
		
		
		td = document.createElement('td');
		td.innerHTML = '<b>' + tpName + '</b>' + '<br/>' + reportCon;
		td.setAttribute('style',"white-space: normal;");
		
		tdHidden = document.createElement('td');
		tdHidden.innerText = tpId;
		tdHidden.setAttribute('hidden',true);
		tr.append(td);
		tr.append(tdHidden);
		
		let tdButton = document.createElement('td');
		tdButton.className = 'text-center';
		
		let btn1 = document.createElement('button');
		btn1.className = 'btn btn-primary';
		btn1.addEventListener('click', answerDelete);
		btn1.innerText = "요청삭제";
		tdButton.append(btn1);
		
		let blank = " ";
		tdButton.append(blank);
		
		let btn2 = document.createElement('button');
		btn2.className = 'btn btn-secondary';
		btn2.addEventListener('click', packageDelete);
		btn2.innerText = "상품삭제";
		tdButton.append(btn2);
		tr.append(tdButton);
		
		return tr;
	}
	
	function packageDelete(){
		console.log(this);
		let tr = this.parentElement.parentElement;
		let tpId = this.parentElement.parentElement.childNodes[1].innerText;
		console.log(tr);
		console.log(tpId);
		
		fetch("packageReportTripDelete.do?tpId="+tpId, {
			method: 'delete',
		})
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'Success'){
				alert('상품을 삭제하엿습니다.');
			} else if (result.retCode == 'Fail'){
				alert('처리중 오류가 발생.');
			}
		})
	
	}
	
	function answerDelete(){
		console.log(this);
		let tr = this.parentElement.parentElement;
		let tpId = this.parentElement.parentElement.childNodes[1].innerText;
		console.log(tr);
		console.log(tpId);
		
		fetch("packageReportDelete.do?tpId="+tpId, {
			method: 'delete',
		})
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'Success'){
				alert('요청을 삭제하엿습니다.');
				tr.remove();
			} else if (result.retCode == 'Fail'){
				alert('처리중 오류가 발생.');
			}
		})
		.catch(reject => console.log(reject))
	}
	
	fetch('packageReportList.do?pageNum='+${pageDTO.cri.pageNum})
	.then(resolve => resolve.json())
	.then(packageList)
	.catch(function(reject){
	console.log(reject)
	})

	function packageList(result){
		console.log(result);
		let tbl = document.createElement('table');
		tbl.setAttribute('frame','void');
		tbl.className = 'table';
		let thd = document.createElement('thead');
		let tbd = document.createElement('tbody');
		let tr = document.createElement('tr');
		
		let th1 = document.createElement('th');
		th1.innerHTML = '등록 신고' + '  ' + '<small/>';
		th1.className = 'border-gray-200';
		let th2 = document.createElement('th');
		th2.innerText = '기타';
		th2.className = 'border-gray-200 text-center';
		tr.append(th1);
		tr.append(th2);
		thd.append(tr);
		
		for(let i=0; i<result.length; i++){
			delete result[i].mbId;
			delete result[i].tpArea;
			delete result[i].tpDate;
			delete result[i].tpImg;
			delete result[i].tpText;
			delete result[i].tpTheme;
		}
		
		result.forEach(function(item, idx, ary){
			console.log(item);
			tbd.append(makeTr(item));
		})
		
		tbl.append(thd, tbd);
		tbl.setAttribute('border', '1');
		tbl.className='table';
		document.getElementById('reportTable').append(tbl);
	}


</script>