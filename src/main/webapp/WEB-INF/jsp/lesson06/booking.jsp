<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 팬션</title>
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


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />



<link rel="stylesheet" type="text/css" href="/CSS/lesson06/booking.css">
</head>
<body>
	<div id="wrap" class="container">
			<header class=" d-flex justify-content-center align-items-center">
				<div class="display-4 mt-2 mb-2 ">통나무 팬션</div>
			</header>
			<nav class=" d-flex">
				<ul class="nav-ul nav-fill w-100 d-flex align-items-center justify-content-around mt-2">
					<li class="nav-li text-light font-weight-bold"><a class="nav-a text-light" href="#">팬션소개</a></li>
					<li class="nav-li text-light font-weight-bold"><a class="nav-a text-light" href="#">팬션소개</a></li>
					<li class="nav-li text-light font-weight-bold"><a class="nav-a text-light" href="#">팬션소개</a></li>
					<li class="nav-li text-light font-weight-bold"><a class="nav-a text-light" href="#">팬션소개</a></li>
				</ul>
			</nav>
			<section>
				<h1 class="text-center pt-4 mb-4">예약 목록 보기</h1>
				<table class="table text-center">
					<thead>
						<tr>
							<th>이름</th>
							<th>예약날짜</th>
							<th>숙박일수</th>
							<th>숙박인원</th>
							<th>전화번호</th>
							<th>예약상태</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${booking}" var="bookings">
						<tr>
							<td>${bookings.name}</td>
							<td>${bookings.date}</td>
							<td>${bookings.day}</td>
							<td>${bookings.headcount}</td>
							<td>${bookings.phoneNumber}</td>
							<td>
								<c:choose>
									<c:when test="${fn:startsWith(bookings.state, '대기중')}">	
										<span class="text-info">${bookings.state}</span>
									</c:when>
									<c:otherwise>
									<span class="text-success">${bookings.state}</span>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<button type="button" class="del-btn btn btn-danger" data-bookings-id="${bookings.id}">삭제</button>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</section>
			<footer>
				<small class="text-center justify-content-center align-items-center col-9 mt-4">
					<div class="text-secondary ">제주특별자치도 제주시 애월읍</div>
					<div class="text-secondary mt-1">사업자등록번호:111-22-255222/농어촌민박사업자지정/대표:김통목</div>
					<div class="text-secondary mt-1">Copyright@2023 YURIHONG. All Rights RESERVED.</div>
				</small>
			</footer>
	</div>
	
	
	
	
	
<script>
$(document).ready(function() {
	
	$('.del-btn').on('click', function() {
		let id = $(this).data('bookings-id');
		// alert(id);
		
		
		$.ajax({
			
			// request
			type:"POST"
			, url:"/lesson06/booking/delete_booking"
			, data: {"id":id}
			
		
		
			// response
			, success:function(data) {
				if(data.code == 1) {
					location.reload(true);   // 새로고침
				} else {
					alert(data.errorMessage);
				}
			}
			
			
			, error:function(request, status, error) {
				alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
			}
		
		
		
		
		}); // ajax
		
	}); // .del-btn
	
}); // ready


</script>
	
	
</body>
</html>