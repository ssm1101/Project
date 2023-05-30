/**
 * 
 */
function findPass(){
	let id = document.getElementById("id").value;
	let phone = document.getElementById("phone").value;
	
	const findPass = "mbId="+id+"&mbPhone="+phone;
		
	fetch("findPass.do",{
		method:'post',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		body: findPass
	})
	.then(resolve => resolve.json())
	.then(result=>{
		console.log(result)
		if(result.retCode == 'Success'){
			//비밀번호 찾기 성공
			console.log(result.pw)
			alert('비밀번호찾기 성공')
			//location.href='viewPass.do';
		}else{
			//비밀번호 찾기 실패
			alert('비밀번호찾기 실패')
			mbId.forcus();
			}
		})
	.catch(reject=>{
		console.log(reject);
	})
}