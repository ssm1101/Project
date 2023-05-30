<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Primary Meta Tags -->
<title>예담Trip! 통합 관리 시스템</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="title" content="Volt Free Bootstrap Dashboard - Settings">
<meta name="author" content="Themesberg">
<meta name="description"
	content="Volt Pro is a Premium Bootstrap 5 Admin Dashboard featuring over 800 components, 10+ plugins and 20 example pages using Vanilla JS.">
<meta name="keywords"
	content="bootstrap 5, bootstrap, bootstrap 5 admin dashboard, bootstrap 5 dashboard, bootstrap 5 charts, bootstrap 5 calendar, bootstrap 5 datepicker, bootstrap 5 tables, bootstrap 5 datatable, vanilla js datatable, themesberg, themesberg dashboard, themesberg admin dashboard" />
<link rel="canonical"
	href="https://themesberg.com/product/admin-dashboard/volt-premium-bootstrap-5-dashboard">

<!-- Favicon -->
<link rel="apple-touch-icon" sizes="57x57"
	href="./assets/img/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="./assets/img/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="./assets/img/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="./assets/img/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="./assets/img/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="./assets/img/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="./assets/img/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="./assets/img/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="./assets/img/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="./assets/img/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="./assets/img/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="./assets/img/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="./assets/img/favicon/favicon-16x16.png">
<link rel="manifest" href="./assets/img/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="./assets/img/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<!-- Sweet Alert -->
<link type="text/css"
	href="./vendor/sweetalert2/dist/sweetalert2.min.css" rel="stylesheet">

<!-- Notyf -->
<link type="text/css" href="./vendor/notyf/notyf.min.css"
	rel="stylesheet">

<!-- Volt CSS -->
<link type="text/css" href="./css/volt.css" rel="stylesheet">

<script src="//cdn.ckeditor.com/4.20.1/basic/ckeditor.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
	<nav
		class="navbar navbar-dark navbar-theme-primary px-4 col-12 d-lg-none">
		<div class="d-flex align-items-center">
			<button class="navbar-toggler d-lg-none collapsed" type="button"
				data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
				aria-controls="sidebarMenu" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>

	<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>

	<main class="content">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</main>

	<!-- Core -->
	<script src="./vendor/@popperjs/core/dist/umd/popper.min.js"></script>
	<script src="./vendor/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Smooth scroll -->
	<script
		src="./vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>

	<!-- Moment JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.27.0/moment.min.js"></script>

	<!-- Volt JS -->
	<script src="./assets/js/volt.js"></script>
</body>

</html>