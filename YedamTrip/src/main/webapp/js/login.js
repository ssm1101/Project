/**
 * 
 */
function login(){
	let id = document.getElementById("id").value;
	let pw = document.getElementById("pw").value;
	
	const log = "id="+id+"&pw="+pw
	
	if (id == "") {
		alert("아이디를 입력하세요");
		mid.forcus();
		return false;
	};
	
	if (pw == "") {
		alert("비밀번호를 입력하세요");
		mpw.forcus();
		return false;
	};
	
	fetch("loginCheck.do",{
		method:'post',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		body: log
	})
	.then(resolve => resolve.json())
	.then(result=>{
		if(result != null){
			alert('로그인 되었습니다.')
			if(result.mbGrade==1){
				location.href="sellerMain.do"				
			} else if(result.mbGrade==2){
				location.href="adminMain.do"
			} else {				
			location.href="userMain.do"
			}
		}else{
			alert('아이디와 비밀번호를 다시 한 번 확인해주세요')
			location.href="loginForm.do"
		}
	})
	.catch(reject=>{
		console.log(reject);
	})
}