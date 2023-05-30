
function sellerCheckId() {

	let sid = document.getElementById("sid").value;
	const sellerId = "sId=" + sid

	fetch("sellerCkeckId.do", {
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: sellerId
	})
		.then(resolve => resolve.json())
		.then(result => {
			
			if (result == null) {
				//사용가능한 아이디 입니다.
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
				sspw.forcus();
			}
		})
		.catch(reject => {
			console.log(reject);
		})
}


