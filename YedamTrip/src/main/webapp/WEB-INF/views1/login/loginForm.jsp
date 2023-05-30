<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="js/login.js"></script>


  <main id="main">
    <!-- ======= Intro Single ======= -->
    <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">로그인</h1>
              <span class="color-text-a">로그인 해서 예담 트립과 함께 즐거운 여행을 떠나보세요!</span>
            </div>
          </div>
        </div>
      </div>
    </section><!-- End Intro Single-->

    <!-- ======= Contact Single ======= -->
    <section class="contact">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="row">
              <div class="col-md-7">
                <form onsubmit="return false">
                  <div class="col-md-12 mb-3 ">
                    아이디
                  </div>
                  <div class="row">
                    <div class="col-md-12 mb-3">
                      <div class="form-group">
                        <input type="text" name="id" id="id" class="form-control form-control-lg form-control-a"
                          placeholder="아이디를 입력해 주세요." required>
                      </div>
                    </div>
                    <div class="col-md-12 mb-3">
                      비밀번호
                    </div>
                    <div class="col-md-12 mb-3">
                      <div class="form-group">
                        <input name="pw" type="password" id="pw" class="form-control form-control-lg form-control-a"
                          placeholder="비밀번호를 입력해 주세요." required>
                      </div>
                    </div>
                    <div class="col-md-12 text-center">
                      <button type="submit" class="btn btn-b" onclick="login()">로그인</button>
                      <a class="btn btn-c" href="userJoinForm.do">회원가입</a>
                    </div>
                  </div>
                </form>
                <div class="col-md-12 text-center">
                  <div style="padding: 1rem;">
                    <a href="findPassForm.do"><span class="color-b">혹시 비밀번호를 잊으셨나요?</span></a>
                  </div>
                </div>
              </div>
              <div class="col-md-5 section-md-t3">
                <div class="swiper-slide carousel-item-a intro-item bg-image"
                  style="background-image: url(assets/img/slide-2.jpg)"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Contact Single-->
  </main>
  <!-- End #main -->
  
 <script src="js/checkId.js"></script>
 