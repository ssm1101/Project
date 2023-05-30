<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<@ inport
<nav
	class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
	<div class="container">
		<button class="navbar-toggler collapsed" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarDefault"
			aria-controls="navbarDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span></span> <span></span> <span></span>
		</button>
		<a class="navbar-brand text-brand" href="userMain.do"><span
			class="color-b">����</span>Trip!</a>

		<div class="navbar-collapse collapse justify-content-center"
			id="navbarDefault">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="userMain.do">����</a></li>
				<li class="nav-item"><a class="nav-link" href="packageList.do">��Ű��</a></li>
				<li class="nav-item"><a class="nav-link" href="noticeMainList.do">��������</a></li>
				<c:choose>
					<c:when test="${empty id }">
						<li class="nav-item"><a class="nav-link" href="loginForm.do">���ǻ���</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="qnaForm.do">���ǻ���</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${grade==0}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">���� ������</a>
							<div class="dropdown-menu">
								<a class="dropdown-item active" href="myPageView.do">������</a> <a
									class="dropdown-item" href="likeItListForm.do">����</a> <a
									class="dropdown-item " href="orderList.do">���Ÿ��</a> 
									<a class="dropdown-item " href="myReview.do">������</a>
							</div></li>
					</c:when>
					<c:when test="${grade==1}">
						<li class="nav-item">
						<a class="nav-link" href="sellerMain.do">�Ǹ��� ������</a>
						</li>
					</c:when>
					<c:when test="${grade==2}">
						<li class="nav-item">
						<a class="nav-link" href="adminMain.do">������ ������</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>

		<ul class="flex no-margin tag">
			<li class="list-style-none"><c:choose>
					<c:when test="${not empty id}">
						<a href="logout.do" class="btn btn-b-n"> <i
							class="bi bi-box-arrow-in-right" style="margin-right: 5px;"></i>
							�α׾ƿ�
						</a>
					</c:when>
					<c:otherwise>
						<a href="loginForm.do" class="btn btn-b-n"> <i
							class="bi bi-box-arrow-in-right" style="margin-right: 5px;"></i>
							�α���
						</a>
					</c:otherwise>
				</c:choose></li>
				
			<li class="list-style-none">
				<div
					class="btn btn-b-a navbar-toggle-box navbar-toggle-box-collapse"
					data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
					<i class="bi bi-search"></i>
				</div>
			</li>
		</ul>
	</div>
</nav>