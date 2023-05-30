<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
      <div class="col-12 col-xl-8">
       <form id="restart_submit" onsubmit="return false">
          <div class="card card-body border-0 shadow mb-4">
            <h2 class="h5 mb-4">QnA</h2>
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="first_name">문의내용</label>
                <textarea class="form-control" id="first_name" rows="4" readonly>${vo.psTitle }</textarea>
              </div>
              <div class="col-md-12 mb-3">
                <label for="first_name">답변</label>
                <textarea class="form-control" id="textarea" rows="4" placeholder="${vo.psText }"></textarea>
              </div>
            </div>
          </div>
          <div class="mt-3 mb-4">
            <button class="btn btn-primary animate-up-2" id="updateBtn" type="submit">답변달기 및 수정하기</button>
            <button class="btn btn-primary animate-up-2" id="deleteBtn" type="submit">삭제하기</button>
            <a href="adminQnaForm.do?pageNum=${pageNum }" class="btn btn-secondary">목록으로</a>
          </div>
        </form>
      </div>
    </div>
    
<script>
	document.getElementById('updateBtn').addEventListener('click', updateQna);
	document.getElementById('deleteBtn').addEventListener('click', deleteQna);
	
	function deleteQna(){
		let psId = ${vo.psId };
		let pageNum = ${pageNum };
		
		fetch("noticeDelete.do?psId="+psId, {
			method: 'delete',
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('문의사항이 삭제되었습니다.');
	   			location.href = "adminQnaForm.do?pageNum="+pageNum;
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.');
	   			location.href = "adminQnaForm.do?pageNum="+pageNum;
	   		}
		})
		.catch(reject => console.log(reject))
	}
	
	function updateQna(){
		let psTitle = document.getElementById('first_name').value;
		let psText = document.getElementById('textarea').value;
		let psId = ${vo.psId };
		let mbId = "${vo.mbId }";
		let pageNum = ${pageNum };
		
		console.log(psTitle);
		console.log(psId);
		console.log(psText);
		console.log(mbId);
		console.log(pageNum);
		
		const qna ='psTitle=' + psTitle + '&psText=' + psText + '&psId=' + psId + '&mbId=' + mbId;
		
		fetch("noticeUpdate.do", {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: qna
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('답변이 등록되었습니다.')
	   			location.href = "adminQnaForm.do?pageNum="+pageNum;
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.')
	   			location.href = "adminQnaForm.do?pageNum="+pageNum;
	   		}
		})
		.catch(reject => console.log(reject))
	}
</script>
		
