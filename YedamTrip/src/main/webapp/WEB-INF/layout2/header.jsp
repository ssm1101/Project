<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav
	class="navbar navbar-top navbar-expand navbar-dashboard navbar-dark ps-0 pe-2">
	<div class="container-fluid px-0">
		<div class="d-flex justify-content-between w-100"
			id="navbarSupportedContent">
			<div class="d-flex align-items-center"></div>
			<ul class="navbar-nav align-items-center">
				<li class="nav-item dropdown ms-lg-3">
					<div
						class="media-body ms-2 text-dark align-items-center d-none d-lg-block">
						<b class="text-primary mb-0"> <a href="">${name }</a>
						</b>
					</div>
				</li>
				<li class="nav-item dropdown ms-lg-3"><a
					class="btn btn-primary" href="logout.do"> <svg
							class="icon icon-xxs me-2" fill="none" stroke="currentColor"
							viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
								<path stroke-linecap="round" stroke-linejoin="round"
								stroke-width="2"
								d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1">
								</path>
							</svg> 로그아웃
				</a></li>
				<li class="nav-item dropdown ms-lg-3"><a
					class="btn btn-secondary" href="./userMain.do"> 메인으로 </a></li>
			</ul>
		</div>
	</div>
</nav>