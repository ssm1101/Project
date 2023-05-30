<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="sidebarMenu"
	class="sidebar d-lg-block bg-gray-800 text-white collapse"
	data-simplebar>
	<div class="sidebar-inner px-4 pt-3">
		<div
			class="user-card d-flex d-md-none align-items-center justify-content-between justify-content-md-center pb-4">
			<h2 class="no-margin">안녕하세요, 가보자고님</h2>
			<div class="collapse-close d-md-none">
				<c:choose>
					<c:when test="${grade == 1 }">
						<a href="#sidebarMenu" data-bs-toggle="collapse"
							data-bs-target="#sidebarMenu" aria-controls="sidebarMenu"
							aria-expanded="true" aria-label="Toggle navigation"> <svg
								class="icon icon-xs" fill="currentColor" viewBox="0 0 20 20"
								xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
									d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
									clip-rule="evenodd"></path>
					</svg>
						</a>
					</c:when>
					<c:when test="${grade == 2 }">
						<a href="#sidebarMenu" data-bs-toggle="collapse"
							data-bs-target="#sidebarMenu" aria-controls="sidebarMenu"
							aria-expanded="true" aria-label="Toggle navigation"> <svg
								class="icon icon-xs" fill="currentColor" viewBox="0 0 20 20"
								xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
									d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
									clip-rule="evenodd"></path>
					</svg>
						</a>
					</c:when>
				</c:choose>
			</div>
		</div>
		<ul class="nav flex-column pt-3 pt-md-0">
			<c:choose>
				<c:when test="${grade == 1 }">
					<li class="nav-item"><a href="./sellerMain.do"
						class="nav-link d-flex align-items-center"> <span
							class="sidebar-icon"> <img
								src="./assets/img/brand/light.svg" height="20" width="20"
								alt="Volt Logo">
						</span> <span class="mt-1 ms-1 sidebar-text">예담Trip!</span>
					</a></li>
					
					<li class="nav-item"><a href="./sellerPage.do"
						class="nav-link"> <span class="sidebar-icon"> <svg
									class="icon icon-xs me-2" fill="currentColor"
									viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
							<path d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z"></path>
							<path fill-rule="evenodd"
										d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 110 2H5a1 1 0 01-1-1zm5-1a1 1 0 100 2h1a1 1 0 100-2H9z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">판매자 정보</span>
					</a></li>
					
					<li class="nav-item"><a href="./couponList.do"
						class="nav-link"> <span class="sidebar-icon"> <svg
									class="icon icon-xs me-2" fill="currentColor"
									viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
							<path d="M4 4a2 2 0 00-2 2v1h16V6a2 2 0 00-2-2H4z"></path>
							<path fill-rule="evenodd"
										d="M18 9H2v5a2 2 0 002 2h12a2 2 0 002-2V9zM4 13a1 1 0 011-1h1a1 1 0 110 2H5a1 1 0 01-1-1zm5-1a1 1 0 100 2h1a1 1 0 100-2H9z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">쿠폰 목록</span>
					</a></li>
					
					<li class="nav-item"><a href="./tripList.do" class="nav-link">
							<span class="sidebar-icon"> <svg class="icon icon-xs me-2"
									fill="currentColor" viewBox="0 0 20 20"
									xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">패키지 목록</span>
					</a></li>
					<li class="nav-item"><a href="./productList.do"
						class="nav-link"> <span class="sidebar-icon"> <svg
									class="icon icon-xs me-2" fill="currentColor"
									viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">상품 목록</span>
					</a></li>

					<li class="nav-item"><a href="./sellerQnaForm.do"
						class="nav-link"> <span class="sidebar-icon"> <svg
									class="icon icon-xs me-2" fill="currentColor"
									viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M5 4a3 3 0 00-3 3v6a3 3 0 003 3h10a3 3 0 003-3V7a3 3 0 00-3-3H5zm-1 9v-1h5v2H5a1 1 0 01-1-1zm7 1h4a1 1 0 001-1v-1h-5v2zm0-4h5V8h-5v2zM9 8H4v2h5V8z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">문의사항</span>
					</a></li>
				</c:when>
				<c:when test="${grade == 2 }">
					<li class="nav-item"><a href="./adminMain.do"
						class="nav-link d-flex align-items-center"> <span
							class="sidebar-icon"> <img
								src="./assets/img/brand/light.svg" height="20" width="20"
								alt="Volt Logo">
						</span> <span class="mt-1 ms-1 sidebar-text">예담Trip!</span>
					</a></li>
					<li class="nav-item"><a href="./notice.do" class="nav-link">
							<span class="sidebar-icon"> <svg class="icon icon-xs me-2"
									fill="currentColor" viewBox="0 0 20 20"
									xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M5 4a3 3 0 00-3 3v6a3 3 0 003 3h10a3 3 0 003-3V7a3 3 0 00-3-3H5zm-1 9v-1h5v2H5a1 1 0 01-1-1zm7 1h4a1 1 0 001-1v-1h-5v2zm0-4h5V8h-5v2zM9 8H4v2h5V8z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">공지사항</span>
					</a></li>
					
					<li class="nav-item"><span
						class="nav-link collapsed  d-flex justify-content-between align-items-center"
						data-bs-toggle="collapse" data-bs-target="#submenu-pages-member">
							<span> <span class="sidebar-icon"> <svg
										class="icon icon-xs me-2" fill="currentColor"
										viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd"
											d="M2 5a2 2 0 012-2h8a2 2 0 012 2v10a2 2 0 002 2H4a2 2 0 01-2-2V5zm3 1h6v4H5V6zm6 6H5v2h6v-2z"
											clip-rule="evenodd"></path>
								<path d="M15 7h1a2 2 0 012 2v5.5a1.5 1.5 0 01-3 0V7z"></path>
							</svg>
							</span> <span class="sidebar-text">회원 관리</span>
						</span> <span class="link-arrow"> <svg class="icon icon-sm"
									fill="currentColor" viewBox="0 0 20 20"
									xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
										clip-rule="evenodd"></path>
						</svg>
						</span>
					</span>
						<div class="multi-level collapse " role="list"
							id="submenu-pages-member" aria-expanded="false">
							<ul class="flex-column nav">
								<li class="nav-item"><a class="nav-link"
									href="./userList.do"> <span class="sidebar-text">일반 회원</span>
								</a></li>
								<li class="nav-item"><a class="nav-link"
									href="./sellerList.do"> <span class="sidebar-text">판매자 회원</span>
								</a></li>
							</ul>
						</div></li>
					
					<li class="nav-item"><span
						class="nav-link collapsed  d-flex justify-content-between align-items-center"
						data-bs-toggle="collapse" data-bs-target="#submenu-pages-topad">
							<span> <span class="sidebar-icon"> <svg
										class="icon icon-xs me-2" fill="currentColor"
										viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd"
											d="M2 5a2 2 0 012-2h8a2 2 0 012 2v10a2 2 0 002 2H4a2 2 0 01-2-2V5zm3 1h6v4H5V6zm6 6H5v2h6v-2z"
											clip-rule="evenodd"></path>
								<path d="M15 7h1a2 2 0 012 2v5.5a1.5 1.5 0 01-3 0V7z"></path>
							</svg>
							</span> <span class="sidebar-text">상단 노출</span>
						</span> <span class="link-arrow"> <svg class="icon icon-sm"
									fill="currentColor" viewBox="0 0 20 20"
									xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
										clip-rule="evenodd"></path>
						</svg>
						</span>
					</span>
						<div class="multi-level collapse " role="list"
							id="submenu-pages-topad" aria-expanded="false">
							<ul class="flex-column nav">
								<li class="nav-item"><a class="nav-link"
									href="./topdisplayView.do"> <span
										class="sidebar-text">상단 노출 목록</span>
								</a></li>
								<li class="nav-item"><a class="nav-link"
									href="./topdisplayList.do"> <span class="sidebar-text">상단
											노출 신청 목록</span>
								</a></li>
							</ul>
						</div></li>

					<li class="nav-item"><span
						class="nav-link collapsed  d-flex justify-content-between align-items-center"
						data-bs-toggle="collapse" data-bs-target="#submenu-pages">
							<span> <span class="sidebar-icon"> <svg
										class="icon icon-xs me-2" fill="currentColor"
										viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd"
											d="M2 5a2 2 0 012-2h8a2 2 0 012 2v10a2 2 0 002 2H4a2 2 0 01-2-2V5zm3 1h6v4H5V6zm6 6H5v2h6v-2z"
											clip-rule="evenodd"></path>
								<path d="M15 7h1a2 2 0 012 2v5.5a1.5 1.5 0 01-3 0V7z"></path>
							</svg>
							</span> <span class="sidebar-text">신고 관리</span>
						</span> <span class="link-arrow"> <svg class="icon icon-sm"
									fill="currentColor" viewBox="0 0 20 20"
									xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
										clip-rule="evenodd"></path>
						</svg>
						</span>
					</span>
						<div class="multi-level collapse " role="list" id="submenu-pages"
							aria-expanded="false">
							<ul class="flex-column nav">
								<li class="nav-item"><a class="nav-link"
									href="packageReportListForm.do"> <span class="sidebar-text">상품
											신고</span>
								</a></li>
								<li class="nav-item"><a class="nav-link"
									href="reviewReportListForm.do"> <span class="sidebar-text">리뷰
											신고</span>
								</a></li>
							</ul>
						</div></li>

					<li class="nav-item"><a href="./adminQnaForm.do"
						class="nav-link"> <span class="sidebar-icon"> <svg
									class="icon icon-xs me-2" fill="currentColor"
									viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
										d="M5 4a3 3 0 00-3 3v6a3 3 0 003 3h10a3 3 0 003-3V7a3 3 0 00-3-3H5zm-1 9v-1h5v2H5a1 1 0 01-1-1zm7 1h4a1 1 0 001-1v-1h-5v2zm0-4h5V8h-5v2zM9 8H4v2h5V8z"
										clip-rule="evenodd"></path>
						</svg>
						</span> <span class="sidebar-text">문의사항</span>
					</a></li>
				</c:when>
			</c:choose>

		</ul>
	</div>
</nav>