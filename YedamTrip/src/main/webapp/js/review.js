document.getElementById('btnReview').addEventListener('click', function() {
	let reviewCon = document.getElementById('reviewCon').value;
	let star = document.getElementById('reviewStar');
	let reviewStar = star.options[star.selectedIndex].value;
	let prodId = document.getElementById('tpId').value;
	let mbId = document.getElementById('mbId').value;

	if (!reviewCon) {
		alert("댓글을 입력해 주세요.");
	}

	const review = 'reviewCon=' + reviewCon + '&reviewStar=' + reviewStar
		+ '&prodId=' + prodId + '&mbId=' + mbId;

	fetch('insertReview.do', {
		method: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: review
	})
		.then(resolve => resolve.json())
		.then(result => {
			alert('댓글이 등록 되었습니다.');
			location.href = 'reviewList.do?prodId=' + prodId;
		})
		.catch(function(reject) {
			console.log(reject);
		})
})