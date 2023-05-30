<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="js/modMyPage.js"></script>
 
  <main id="main">
    <!-- ======= Contact Single ======= -->
    <section class="contact">
      <div class="container">
        <div class="row">
          <section class="intro-single">
            <div class="container">
              <div class="row">
                <div class="col-md-12 col-lg-8">
                  <div class="title-single-box">
                    <h1 class="title-single">회원 정보</h1>
                    <span class="color-text-a">자신의 정보를 확인하거나 수정할 수 있습니다.</span>
                  </div>
                </div>
              </div>
            </div>
          </section>

          <div class="row">
            <div class="col-md-12 col-lg-8">
             
              <input type="hidden" id="mbId" value="${id}">
                <div class="col-md-12 mb-3">
                  <h5>이름</h5>
                  <p id="myName">${vo.mbName } </p>
                </div> 
                <div class="col-md-12 mb-3">
                  <h5>아이디</h5>
                  <p id="myId">${vo.mbId } </p>
                </div>
                <div class="col-md-12 mb-3">
                  <h5>비밀번호</h5>
                  <input value="${vo.mbPw }" type="password" vo class="form-control form-control-lg form-control-a"
                    id ="pw" placeholder="비밀번호를 입력해 주세요." required>
                </div>
                <div class="col-md-12 mb-3">
                  <h5>비밀번호 확인</h5>
                  <input type="password" value="${vo.mbPw }" class="form-control form-control-lg form-control-a"
                    id="chkpw" placeholder="비밀번호를 다시 입력해 주세요." required>
                </div>
                <div class="col-md-12 mb-3">
                  <h5>연락처</h5>
                  <input type="text" value="${vo.mbPhone }" class="form-control form-control-lg form-control-a"
                    id="phone" placeholder="연락처를 입력해 주세요." required>
                </div>
                <div class="col-md-12 mb-3">
                  <h5>이메일</h5>
                  <input type="text" value="${vo.mbEmail }"class="form-control form-control-lg form-control-a"
                    id="email" placeholder="이메일을 입력해 주세요." required>
                </div>
                <div class="col-md-12 text-center">
                  <button type="submit" class="btn btn-b" onclick="modmypage()">수정하기</button>
                  <a class="btn btn-c" type="submit" onclick="myPageView.do">취소하기</a>
                </div>
            </div>
            
          </div>
        </div>
      </div>
    </section>
    <!-- End Contact Single-->
  </main>
  <!-- End #main -->
  
 