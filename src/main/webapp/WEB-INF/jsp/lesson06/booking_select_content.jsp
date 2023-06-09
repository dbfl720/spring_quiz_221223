<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div>
	<img id="bannerImage" src="/img/booking/test06_banner1.jpg" id=""
		alt="이미지1" width="1100" height="600" class="w-100">
</div>
<article class="d-flex">

	<%-- content1 --%>
	<div class="content1 col-4">
		<div class="font-weight-bold">
			<a href="/lesson06/booking/booking_insert_view"
				class="checkReservation">실시간 예약하기</a>
		</div>
	</div>


	<%-- contetn2 --%>
	<div class="content2">
		<h2 class="mt-4 ml-3">예약확인</h2>
		<div class="ml-3 mr-3">
			<div class="d-flex justify-content-around mb-3">
				<small
					class="font-weight-bold text-center text-center align-items-center d-flex">이름</small>
				<div class="ml-2 ">
					<input id="name" type="text" class="inputName form-control">
				</div>
			</div>
			<div class="d-flex mb-3 d-flex justify-content-around">
				<small
					class="font-weight-bold text-center text-center align-items-center d-flex">전화번호</small>
				<div class="ml-2">
					<input id="phoneNumber" type="text"
						class="inputPhoneNumber form-control col-12 mr-2">
				</div>
			</div>
			<div class="d-flex justify-content-end">
				<button id="selectBtn" type="button" class="btn btn-success mr-3">조회하기</button>
			</div>
		</div>
	</div>

	<!-- content3 -->
	<div class="content3 font-weight-bold text-light">
		<small>예약문의:</small> 010-000-1111
	</div>

</article>




<script>
	$(document).ready(
			function() {

				$('#selectBtn').on(
						'click',
						function() {

							// validation
							let name = $("#name").val().trim();
							let phoneNumber = $("#phoneNumber").val().trim();

							if (name == "") {
								alert("이름일 입력하세요.");
								return;
							}

							if (phoneNumber == "") { // startWith 사용해서 전화번호 010으로 시작하는거 ~ check. 
								alert("전화번호를 입력하세요.");
								return;
							}

							// ajax 호출 -> 서버 전송
							$.ajax({
								// request
								type : "GET" //  get일 때는 type 안써도 됨.
								,
								url : "/lesson06/booking/booking_select",
								data : {
									"name" : name,
									"phoneNumber" : phoneNumber
								} // 어떤 데이터로 넘길 것인가..? 파라미터 지정해주기! 

								// response
								,
								success : function(data) { // jquery ajax 함수가 json string을 object로 파싱해줌
									if (data.join == "조회 불가") {
										alert("예약 내역이 없습니다.");
									} else {
										//data.booking.name
										alert("이름 : " + data.booking.name
												+ "\n날짜 : " + data.booking.date.slice(0,10)
												+ "\n일수 : " + data.booking.day
												+ "\n인원 : " + data.booking.headcount
												+ "\n상태 : " + data.booking.state);
										location.reload(true);   // 새로고침
									}
								}

								,
								error : function(request, status, error) {
									alert("예약 내역을 조회하는데 실패했습니다.");
									location.reload(true);   // 새로고침
								}

							}); // ajax 

						}); // selectBtn

				// 배너 순회
				let bannerList = [ "/img/booking/test06_banner1.jpg",
						"/img/booking/test06_banner2.jpg",
						"/img/booking/test06_banner3.jpg",
						"/img/booking/test06_banner4.jpg" ];
				let currentIndex = 1;

				setInterval(function() {
					$('#bannerImage').attr('src', bannerList[currentIndex]) // 속성 변경 - attr
					console.log(currentIndex);
					currentIndex++;
					// 4 -  0 1 2 3       
					if (currentIndex == bannerList.length) {
						currentIndex = 0;
					}

				}, 2000); // 임명함수 , 3초 - 3000 
			}); // ready
</script>