<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가게 리스트 페이지</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.4.js"
	integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
	
<link rel="stylesheet" type="text/css" href="/CSS/lesson02/store.css">
</head>
<body>
	<div id="wrap" class="container bg-dark">
		<header class="bg-info text-center d-flex justify-content-center align-items-center">
			<span class="headerText text-light ">배탈의 민족</span>
		</header>
		<section class="bg-warning">
			<span class="display-4">우리동네 가게</span>
				<c:forEach items="${store}" var="stores">
					<div class="sectionBox">
					<div class="font-weight-bold">${stores.name}</div>
					<div>전화번호 : ${stores.phoneNumber}</div>
					<div>주소 : ${stores.address}</div>
					</div>
				</c:forEach>
		</section>
		<footer class="bg-danger">
			<div class="pt-3">
				<span class="font-weight-bold  d-flex ">(주)우와한형제</span>
				<small class="text-secondary">고객센터 : 1500-1500</small>
			</div>
		</footer>
	
	</div>
</body>
</html>