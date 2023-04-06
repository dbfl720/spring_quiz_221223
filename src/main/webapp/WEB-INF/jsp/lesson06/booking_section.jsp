<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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