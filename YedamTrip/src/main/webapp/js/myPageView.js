/**
 * 
 */

	fetch('myPage.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		let myname = document.getElementById('myname')
		myname.innerText=result.mbId;
		let myid = document.getElementById('myid')
		myname.value
		myid.innerText=result.mbName;
		let myphone = document.getElementById('myphone')
		myphone.innerText=result.mbPhone;
		let myemail = document.getElementById('myemail')
		myemail.innerText=result.mbEmail;
	}
)

