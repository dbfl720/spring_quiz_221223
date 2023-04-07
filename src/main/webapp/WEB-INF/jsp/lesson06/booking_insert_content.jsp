<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container d-flex justify-content-center align-items-center">
	<div>
		<h1 class="mt-5 mb-5 text-center ">예약하기</h1>
		<div class="font-weight-bold">이름</div>
		<div><input id="name" class="form-control reserveInput1 mb-3"></div>
		<div class="font-weight-bold">예약날짜</div>
		<div><input id="date" class="form-control reserveInput1  mb-3"></div>
		<div class="font-weight-bold">숙박일수</div>
		<div><input id="day" class="form-control reserveInput1 col-12 mb-3"></div>
		<div class="font-weight-bold">숙박인원</div>
		<div><input id="headcount" class="form-control reserveInput1 col-12 mb-3"></div>
		<div class="font-weight-bold">전화번호</div>
		<div><input id="phoneNumber" class="form-control reserveInput1 col-12 mb-3"></div>
		<div><button id="addBookingBtn" type="button" class="reserveInput1 btn btn-warning mt-5">예약하기</button></div>
	</div>
</div>


<script>
$(document).ready(function() {
			
	// datepicker
		$('#date').datepicker({
			dateFormat: 'yy-mm-dd'
			, minDate:0  // 오늘부터 그 뒤 선택
		});

	
			
	// 추가
	$("#addBookingBtn").on("click", function(){
		
		// validation
	 	let name = $("#name").val().trim();
		let headcount = $("#headcount").val().trim();
		let day = $("#day").val().trim();
		let date = $("#date").val().trim();
		let phoneNumber = $("#phoneNumber").val().trim();
		
		
		
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
		
		if (isNaN(day)) { // ** 숫자가 아닌 값 들어오면 true
			alert("숙박일수는 숫자만 입력 가능합니다.");
			return;
		}
		
		if (day > 14) {
			alert("숙박일수는 14일 이내로 가능합니다.");
			return;
		}
		
		
		if (headcount == "") {
			alert("숙박인원을 입력하세요.");
			return;
		}
		
		if (headcount > 30) {
			alert("숙박인원은 30명 이내로 가능합니다.");
			return;
		} 
		
		
		if (isNaN(headcount)) { // ** 숫자가 아닌 값 들어오면 true
			alert("숙박인원는 숫자만 입력 가능합니다.");
			return;
		}

		if (phoneNumber == "") {
			alert("전화번호를 입력하세요.");
			return;
		}
		
		if (phoneNumber.startsWith("010") == false) {
			alert("010으로 시작하는 번호를 입력해주세요.");
			return;
		}
		
		
		
   	    console.log(phoneNumber.length);
		 if (phoneNumber.length > 13) {
			alert("전화번호는 '-'를 포함한 총 13자리 이내로 적어주세요.");
			return;
		} 
		
		
		
		
		
		// ajax 호출 => 서버 전송
		$.ajax({
			// request  // *** 요청이 안되면 여기를 봐라!!! 
			type:"POST"
			, url:"/lesson06/booking/insert_booking"
			, data:{"name":name, "headcount":headcount, "day":day,  "date":date, 
				    "phoneNumber":phoneNumber}
			
		
		
			// response
			, success:function(data) {  // jquery ajax 함수가 json string을 object로 파싱해줌
				if (data.code = 1) {
					alert(data.result);
					location.href = "/lesson06/booking/booking_view";  // get방식으로 보내줌.
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