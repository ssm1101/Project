<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="click-closed"></div>
  <!--/ Form Search Star /-->
  <div class="box-collapse">
    <div class="title-box-d">
      <h3 class="title-d">검색</h3>
    </div>
    <span class="close-box-collapse right-boxed bi bi-x"></span>
    <div class="box-collapse-wrap form">
      <form class="form-a" action="tripKeywordSearch.do" method="post">
        <div class="row">
          <div class="col-md-12 mb-2">
            <div class="form-group">
              <label class="pb-2" for="Type">키워드</label>
              <input type="text" class="form-control form-control-lg form-control-a" placeholder="키워드를 검색하세요" name="tripName">              
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="city">지역</label>
              <select class="form-control form-select form-control-a" id="city" name="tripArea">
              	<option>전체</option>
              			<script>
							console.log(tripArea)
						</script>
              	
					<c:forEach var="area" items="${tripArea }">

						<option value="${area.tpArea}">${area.tpArea}</option>
					
					</c:forEach>     	
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group mt-3">
              <label class="pb-2" for="Type">테마</label>
              <select class="form-control form-select form-control-a" id="Type" name="tripTheme">
                <option>전체</option>
                
                	<c:forEach var="vo" items="${tripTheme }">
                		<option value="${vo.tpTheme}">${vo.tpTheme}</option>
                	</c:forEach>                
              
              </select>
            </div>
          </div>
          <div class="col-md-12">
            <button type="submit" class="btn btn-b">검색</button>
          </div>
        </div>
      </form>
    </div>
  </div><!-- End Property Search Section -->>
