<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container">

	<h1 class="mt-2 mb-2 text-center ">예약하기</h1>
	<div class="font-weight-bold">이름</div>
	<div><input id="name" class="form-control  col-5 mb-3"></div>
	<div class="font-weight-bold">예약날짜</div>
	<div><input id="date" class="form-control  col-5 mb-3"></div>
	<div class="font-weight-bold">숙박일수</div>
	<div><input id="day" class="form-control  col-5 mb-3"></div>
	<div class="font-weight-bold">숙박인원</div>
	<div><input id="headcount" class="form-control  col-5 mb-3"></div>
	<div class="font-weight-bold">전환번호</div>
	<div><input id="phoneNumber" class="form-control  col-5 mb-3"></div>
	<div></div><input id="state" class="d-none" value="대기중">대기중</div>
	<div><button id="addBookingBtn" type="button" class="btn btn-warning col-5">예약하기</button></div>
</div>


<script>
$(document).ready(function() {
			
	// datepicker
	 $(function() {
		$('#date').datepicker({
			dateFormat: 'yy-mm-dd'
		});
	});
		 
			
			
			
			
	// 추가
	$("#addBookingBtn").on("click", function(){
		
		// validation
	 	let name = $("#name").val().trim();
		let headcount = $("#headcount").val().trim();
		let day = $("#day").val().trim();
		let date = $("#date").val().trim();
		let phoneNumber = $("#phoneNumber").val().trim();
		let state = $("#state").val();
		
		
		if (name == "") {
			alert("이름을 입력하세요.");
			return;
		}
		
		if (date == "") {
			alert("예약날짜를 입력하세요.");
			return;
		}
		
		
		if (day == "") {
			alert("숙박일수를 입력하세요.");
			return;
		}
		
		if (headcount == "") {
			alert("숙박인원을 입력하세요.");
			return;
		}
		

		if (phoneNumber == "") {
			alert("전화번호를 입력하세요.");
			return;
		}
		
		
		
		
		
		// ajax 호출 => 서버 전송
		$.ajax({
			// request
			type:"POST"
			, url:"/lesson06/booking/insert_booking"
			, data:{"name":name, "headcount":headcount, "day":day,  "date":date, 
				    "phoneNumber":phoneNumber,  "state":state}
			
		
		
			// response
			, success:function(data) {  // jquery ajax 함수가 json string을 object로 파싱해줌
				if (data.code = 1) {
					location.href = "/lesson06/booking/booking_insert_view";
				} else {
					alert(data.errorMessage);
				}
			}
			
			, error:function(request, status, error) {
				alert("요청에 실패했습니다. 관리자에게 문의해주세요.");
			}
			
			
			
		});  // ajax

		
		
	}); // 추가
			
			

});  // ready
			
	
	
</script>