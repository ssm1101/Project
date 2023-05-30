<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-single-box">
              <div class="col-md-7">
                <h1 class="title-single">${reviewList.mbId }</h1>
                <p class="color-text-a">${reviewList.reviewCon }</p>
                <p class="color-text-a tag">
                  <span><i class="bi bi-star-fill"></i> <a>${reviewList.reviewStar } </a> / <a> ${reviewList.reviewDate }</a></span>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section><!-- End Intro Single-->

    <!-- ======= Property Single ======= -->
    <section class="property-single nav-arrow-b">
      <div class="container">
        <div class="row section-t4">
          <div class="col-sm-12">
            <div class="row justify-content-between">
              <div class="col-md-12 section-md-t3">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="title-box-d">
                      <h3 class="title-d">신고 사유</h3>
                    </div>
                  </div>
                </div>
                <!--  <form action=""> -->
                  <div class="property-description mb-4">
                    <textarea id="textMessage" class="form-control" placeholder="신고 사유를 입력해 주세요." name="message"
                      cols="45" rows="8" required="" style="resize: none;"></textarea>
                  </div>
                  <div class="text-center">
                    <button id="addBtn" class="btn btn-b">신고하기</button>
                    <a href="reviewList.do?prodId=${reviewList.tpId}" class="btn btn-c">취소하기</a>
                  </div>
                <!--  </form> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
<script>
	document.getElementById('addBtn').addEventListener('click', insertReviewReport);
	
	function insertReviewReport(){
		let reviewId = ${reviewList.reviewId};
		let ReportCon = document.getElementById('textMessage').value;
		console.log(reviewId);
		console.log(ReportCon);
		
		const report = 'reviewId=' + reviewId + '&ReportCon=' + ReportCon;
		
		fetch("insertReviewReport.do", {
			method: 'post',
	   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   		body: report
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('신고가 접수되었습니다.')
	   			location.href = "userMain.do";
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.')
	   			location.href = "userMain.do";
	   		}else if(result.retCode=="Overlap"){
	   			alert('이미 신고가 접수된 리뷰입니다.')
	   			location.href = "userMain.do";
	   		}
		})
		.catch(reject => console.log(reject))
	}
</script>