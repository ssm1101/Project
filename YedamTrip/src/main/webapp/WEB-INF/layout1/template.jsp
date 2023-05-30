<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>예담Trip!</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
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
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="./assets/img/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<!-- Vendor CSS Files -->
<link href="./assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link href="./assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="./assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="./assets/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<!-- Sidebar-->
		<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
			<!-- Page content-->
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="./assets/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Template Main JS File -->
	<script src="./assets/js/main.js"></script>
</body>
</html>

