/**
 * 
 */

function userInsert() {

	//document.getElementById('userBtn').addEventListener('click',userchk);


	let mname = document.getElementById('mname').value;
	let mid = document.getElementById('mid').value;
	let mpw = document.getElementById('mpw').value;
	let mphone = document.getElementById('mphone').value;
	let memail = document.getElementById('memail').value;
	let mmpw = document.getElementById('mmpw').value;
	//post로 보낼때는 자바스크립트 객체를 활용
	//get으로 보낼 때는 나열 형식으로

	const user = "mbName=" + mname + "&mbId=" + mid + "&mbPw=" + mpw +"&mmbpw=" + mmpw + "&mbPhone=" + mphone + "&mbEmail=" + memail


	let pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,25}$/;
	
	//유효성 검사
	if (mname == "") {
		alert("이름을 입력하세요");
		mname.forcus();
		return false;
	}else if (mid == "") {
		alert("아이디를 입력하세요");
		mid.forcus();
		return false;
	}else if (!pwdCheck.test(mpw)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 4~25자리 사용해야 합니다.");
		mpw.focus();
		return false;
	}else if (mpw == "") {
		alert("비밀번호를 입력하세요");
		mpw.forcus();
		return false;
	}else if (mmpw == "") {
		alert("비밀번호 확인을 입력하세요");
		mpw.forcus();
		return false;
	}else if (mpw != mmpw) {
		alert("비밀번호가 일치하지 않습니다.");
		mmpw.forcus();
		return false;
	}else if (mphone == "") {
		alert("연락처를 입력하세요");
		mphone.forcus();
		return false;
	}else if (memail == "") {
		alert("이메일을 입력하세요");
		memail.forcus();
		return false;
	};

	//post=> command 
	console.log(user);

	fetch("userInsert.do", {
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: user
	})
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'Success') {
				alert('처리완료')
				location.href = "loginForm.do"
			} else if (result.retCode == 'Fail') {
				alert('처리 중 에러');
			}
		})
		.catch(reject => {
			console.log(reject);
		})
}






