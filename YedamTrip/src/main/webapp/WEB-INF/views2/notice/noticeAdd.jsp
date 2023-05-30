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
                <input class="form-control" id="first_name" type="text" placeholder="제목을 입력해 주세요." required>
              </div>
              <div class="col-md-12 mb-3">
                <label for="first_name">내용</label>
                <textarea class="form-control" placeholder="내용을 입력해 주세요." id="textarea" rows="4"></textarea>
              </div>
            </div>
          </div>
          <div class="mt-3 mb-4">
            <button class="btn btn-primary animate-up-2" id="addBtn" type="submit">등록하기</button>
            <a href="notice.do" class="btn btn-secondary">취소하기</a>
          </div>
        </form>
      </div>
    </div>
    
<script>
   document.getElementById('addBtn').addEventListener('click', addNootice);

   function addNootice(){
   	let psTitle = document.getElementById('first_name').value;
   	let psText = document.getElementById('textarea').value;
   	//로그인 아이디 세션값 가져와야함   ex)session.getAttribute("user_id");
   	let mbId = '<%=(String) session.getAttribute("id")%>';
   	console.log(mbId);
   	
   	const notice = 'psTitle=' + psTitle + '&psText=' + psText + '&mbId=' + mbId;
   	
   	fetch("noticeAdd.do", {
   		method: 'post',
   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
   		body: notice
   	})
   	.then(resolve => resolve.json())
   	.then(result => {
   		console.log(result);
   		if(result.retCode=="Success"){
   			alert('공지사항이 추가되었습니다.')
   			location.href = "notice.do";
   		}else if(result.retCode=="Fail"){
   			alert('처리중 오류 발생.')
   			location.href = "notice.do";
   		}
   	})
   	.catch(reject => console.log(reject))
   	
   }
</script>
   
  