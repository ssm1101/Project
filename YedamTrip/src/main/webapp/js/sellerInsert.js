/**
 * 
 */
function sellerInsert(e) {
	let sname = document.getElementById('sname').value;
	let sid = document.getElementById('sid').value;
	let spw = document.getElementById('spw').value;
	let sspw = document.getElementById('sspw').value;
	let sphone = document.getElementById('sphone').value;
	let semail = document.getElementById('semail').value;
	//let sfile = document.getElementById('sfile').value;

	const seller = "mbName=" + sname + "&mbId=" + sid + "&mbPw=" + spw +"&mbPhone=" + sphone + "&mbEmail=" + semail
	 //+ "&sfile=" + sfile
	console.log(seller)
	
	let pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{4,25}$/;
	
	//유효성 검사
	if (sname == "") {
		alert("이름을 입력하세요");
		sname.forcus();
		return false;
	}else if (sid == "") {
		alert("아이디를 입력하세요");
		sid.forcus();
		return false;
	}else if (!pwdCheck.test(spw)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 4~25자리 사용해야 합니다.");
		spw.focus();
		return false;
	}else if (spw == "") {
		alert("비밀번호를 입력하세요");
		spw.forcus();
		return false;
	}else if (sspw == "") {
		alert("비밀번호 확인을 입력하세요");
		spw.forcus();
		return false;
	}else if (spw != sspw) {
		alert("비밀번호가 일치하지 않습니다.");
		sspw.forcus();
		return false;
	}else if (sphone == "") {
		alert("연락처를 입력하세요");
		sphone.forcus();
		return false;
	}else if (semail == "") {
		alert("이메일을 입력하세요");
		semail.forcus();
		return false;
	};

	fetch("sellerInsert.do", {
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: seller
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






