function checkId() {

	let checkId = document.getElementById("mid").value;
	console.log(checkId);
	const checkIds = "mbId=" + checkId

	fetch("checkId.do", {
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: checkIds
	})
		.then(resolve => resolve.json())
		.then(result => {
			
			if (result == null) {
				//사용가능한 아이디 입니다.
				//alert('사용가능한 아이디입니다.');
				let div =  document.querySelector("#idchk");
				let divPtag = document.querySelector("#idchk").firstElementChild;
				if(divPtag !=null){
					divPtag.remove();
				}
				
				let pTag = document.createElement("p");
				pTag.innerText='사용가능한 아이디입니다.';
				pTag.className="color-b";
				document.getElementById("idchk").append(pTag);
			} else {
				//이미 존재하는 아이디입니다. 
				let div =  document.querySelector("#idchk");
				let divPtag = document.querySelector("#idchk").firstElementChild;
				if(divPtag !=null){
					divPtag.remove();
				}
				
				let pTag = document.createElement("p");
				pTag.innerText='이미 존재하는 아이디입니다';
				pTag.className="color-c";
				document.getElementById("idchk").append(pTag);
				mmpw.forcus();
			}
		})
		.catch(reject => {
			console.log(reject);
		})
}


