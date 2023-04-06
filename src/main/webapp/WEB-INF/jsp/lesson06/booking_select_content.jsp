<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
	<img src="/img/booking/test06_banner1.jpg" id="" alt="이미지1" width="1100" height="600" class="w-100">
</div>
<article class="d-flex">

	<%-- content1 --%>
	<div class="content1">
		<div class="font-weight-bold"><a href="#">실시간 예약하기</a></div>
	</div>
	
	
	<%-- contetn2 --%>
	<div class="content2">
		<h2>예약확인</h2>
		<div>
			<div class="d-flex">
				<div>이름 :</div>
				<div class="ml-2"><input id="name" type="text" class="form-control"></div>
			</div>
			<div class="d-flex">
				<div>전화번호 :</div>
				<div class="ml-2"><input id="phoneNumber" type="text" class="form-control"></div>
			</div>
			<btton id="selectBtn" type="button" class="btn btn-success">조회 하기</btton>	
		</div>
	</div>
	
	<!-- content3 -->
    <div class="content3 font-weight-bold"><small>예약문의:</small> 010-000-1111</div>
	
</article>




<script>
$(document).ready(function() {
	
	$('#selectBtn').on('click', function() {
		
		// validation
		let name = $("#name").val().trim();
		let phoneNumber = $("#phoneNumber").val().trim();
		
		if (name == "") {
			alert("이름일 입력하세요.");
			return;
		}
		
		if (phoneNumber == "") {
			alert("전화번호를 입력하세요.");
			return;
		}
		
		
		
		// ajax 호출 -> 서버 전송
		 $.ajax({
			// request
			type:"POST"
			, url:"/lesson06/booking/booking_select"
			, data:{"name":name, "phoneNumber":phoneNumber}
			
		 
		    // response
		    , success:function(data) { // jquery ajax 함수가 json string을 object로 파싱해줌
		    	if (data.join == "조회 불가") {
		    		alert("예약 내역이 없습니다.");
		    	} else {
		    		alert("이름 : " + data.name + "\n" +
		    			  "날짜 : " + data.date + "\n" +
		    			  "일수 : " + data.day + "\n" +
		    			  "인원 : " + data.headCount + "\n" +
		    			  "상태 : " + data.state);
	 		
		    	}
		    }
			
		}); // ajax 
		
	});  // selectBtn
	
	
}); // ready

</script>