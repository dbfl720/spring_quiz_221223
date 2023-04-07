<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1 class="text-center pt-4 mb-5 mt-3">예약 목록 보기</h1>
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
							<td><fmt:formatDate value="${bookings.date}" pattern="yyyy년 M월 d일"/></td>
							<td>${bookings.day}</td>
							<td>${bookings.headcount}</td>
							<td>${bookings.phoneNumber}</td>
							<td>
								<c:choose>
									<c:when test="${bookings.state eq '대기중'}">	
										<span class="text-info">${bookings.state}</span>
									</c:when>
									<c:when test="${bookings.state eq '확정'}">
									<span class="text-success">${bookings.state}</span>
									</c:when>
									<c:when test="${bookings.state eq '취소'}">
									<span class="text-danger">${bookings.state}</span>
									</c:when>
									<c:otherwise>
										${bookings.state}
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
				
				
				
<script>
$(document).ready(function() {
	
	$('.del-btn').on('click', function() {
		let id = $(this).data('bookings-id');
		// alert(id);
		
		
		
		$.ajax({
			
			// request
			type:"DELETE"   //post 계열, 브라우저로 직접 치고 못들어감.
			, url:"/lesson06/booking/delete_booking"
			, data: {"id":id}   // 파라미터 넘기기. 
			
		
		
			// response
			, success:function(data) {
				if(data.code == 1) {
					alert("삭제 되었습니다.");
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