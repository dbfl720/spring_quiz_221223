<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


<link rel="stylesheet" type="text/css" href="/CSS/lesson05/weather.css">
</head>
<body>
	<div id="wrap" class="container bg-info">

			<div class="d-flex">
			<aside class="aside1 col-2">
				<nav class="">
					<div class="text-light text-center">
						<img
							src="data:image/jpeg;base64,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"
							alt="기상청 이미지" height="150" width="150">
					</div>
					<ul>
						<li class="nav-item text-light">날씨</li>
						<li class="nav-item text-light">날씨입력</li>
						<li class="nav-item text-light">테마날씨</li>
						<li class="nav-item text-light">관측 기후</li>

					</ul>
				</nav>
			</aside>
			
			
		<section class="bg-warning col-10">
			<h3>과거 날씨</h3>
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
						</tr>
					</tbody>
				</table>
			
		</section>
		</div>
		<footer class="bg-danger d-flex">
			<img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS43_Cb5blGpQibxSbGK4cTndyScJSR0GnGPA&usqp=CAU"
				alt="기상청 이미지" width="230" height="120" >
			<div>
				<address class="text-secondary">(07062) 서울시 동작구 여의대방로16길
					61</address>
			</div>
			<div>
				<address class="text-secondary">Copyright@2020 KMA. All
					Rights RESERVED.</address>
			</div>
		</footer>
	</div>
</body>
</html>