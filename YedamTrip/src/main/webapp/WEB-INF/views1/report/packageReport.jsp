<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-single-box">
              <div class="col-md-3">
                <img src="attech/${tripPackageList.tpImg }" alt="" style="width: 95%; margin-bottom: 2em;">
              </div>
              <div class="col-md-7">
                <h1 class="title-single">${tripPackageList.tpName }</h1>
                <p class="color-text-a">${tripPackageList.tpText }</p>
                <p class="color-text-a tag">
                  <span class="color-b"><i class="icon-star"></i>★${tripPackageList.star }</span>
                  <span class="color-d">${tripPackageList.tpArea }</span>
                  <span class="color-d">${tripPackageList.tpTheme }</span>
                  <span class="color-d">${tripPackageList.tpDate }</span>
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
                    <a href="packageList.do" class="btn btn-c">취소하기</a>
                  </div>
                <!--  </form> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
<script>
	document.getElementById('addBtn').addEventListener('click', addPackageReport);
	
	function addPackageReport(){
		let tpId = ${tripPackageList.tpId};
		let ReportCon = document.getElementById('textMessage').value;
		console.log(tpId);
		console.log(ReportCon);
		
		const report = 'tpId=' + tpId + '&ReportCon=' + ReportCon;
		
		fetch("packageReportAdd.do", {
			method: 'post',
	   		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	   		body: report
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if(result.retCode=="Success"){
	   			alert('신고가 접수되었습니다.')
	   			location.href = "packageList.do";
	   		}else if(result.retCode=="Fail"){
	   			alert('처리중 오류 발생.')
	   			location.href = "packageList.do";
	   		}else if(result.retCode=="Overlap"){
	   			alert('이미 신고가 접수된 패키지입니다.')
	   			location.href = "packageList.do";
	   		}
		})
		.catch(reject => console.log(reject))
	}
</script>