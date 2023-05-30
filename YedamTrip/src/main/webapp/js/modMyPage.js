/**
 * 
 */
function modmypage(){
	
	let mbId = document.getElementById("mbId").value;	
	let pw = document.getElementById("pw").value
	let chkpw = document.getElementById("chkpw").value
	let phone = document.getElementById("phone").value
	let email = document.getElementById("email").value
	
	const member = 'pw='+ pw + '&mbId='+ mbId +'&phone=' + phone + '&email=' + email;

	if (pw != chkpw) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	fetch('modMypage.do', {
		method:'post',
		headers : {'Content-Type': 'application/x-www-form-urlencoded'},
		body: member
	})
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result)
		if(result.retCode == 'Success' ){
			alert('정상처리되었습니다.')
			location.href='myPageView.do';
		}else {
			alert('정보수정에 실패했습니다.')
		}
	})
	.catch(reject => {
		console.log(reject);
	})
	
}