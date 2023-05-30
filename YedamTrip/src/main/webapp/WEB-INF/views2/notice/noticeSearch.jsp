<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
      <div class="col-12 col-xl-8">
       <form id="restart_submit" onsubmit="return false">
          <div class="card card-body border-0 shadow mb-4">
            <h2 class="h5 mb-4">공지사항 등록</h2>
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="first_name">제목</label>
                <input class="form-control" id="first_name" type="text" required value="${vo.psTitle }">
              </div>
              <div class="col-md-12 mb-3">
                <label for="first_name">내용</label>
                <textarea class="form-control" id="textarea" rows="4">${vo.psText }</textarea>
              </div>
            </div>
          </div>
          <div class="mt-3 mb-4">
            <button class="btn btn-primary animate-up-2" id="updateBtn" type="submit">수정하기</button>
            <button class="btn btn-primary animate-up-2" id="deleteBtn" type="submit">삭제하기</button>
            <a href="notice.do?pageNum=${pageNum }" class="btn btn-secondary">목록으로</a>
          </div>
        </form>
      </div>
    </div>
    
<script>
	document.getElementById('updateBtn').addEventListener('click', updateNotice);
	document.getElementById('deleteBtn').addEventListener('click', deleteNotice);
	let pageNum = ${pageNum };
	
	function deleteNotice(){
		let psId = ${vo.psId };
		
		fetch("noticeDelete.do?psId="+psId, {
			method: 'delete',
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('공지사항이 삭제되었습니다.')
	   			location.href = "notice.do?pageNum="+pageNum;
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.')
	   		}
		})
		.catch(reject => console.log(reject))
	}
	
	function updateNotice(){
		let psTitle = document.getElementById('first_name').value;
		let psText = document.getElementById('textarea').value;
		let psId = ${vo.psId };
		let mbId = '<%=(String) session.getAttribute("id")%>';
		console.log(mbId);
		console.log(psId);
		
		const notice ='psTitle=' + psTitle + '&psText=' + psText + '&psId=' + psId + '&mbId=' + mbId;
		
		fetch("noticeUpdate.do", {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: notice
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('공지사항이 수정되었습니다.')
	   			location.href = "notice.do?pageNum="+pageNum;
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.')
	   		}
		})
		.catch(reject => console.log(reject))
	}
</script>
		
