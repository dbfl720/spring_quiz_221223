<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		
	<c:forEach items="${reviewList}" var="reviewLists">
		<div class="sectionBox mb-4">
		<div class="d-flex">
		<h3>${reviewLists.userName}</h3>
		<div><c:forEach items="${reviewList}" var="point" begin="1" end="5" step="0.5">	
			<img src="/img/star_fill.png" alt="이미지" width="20" height="20"></c:forEach></div>
			
			 	<c:choose>
					<c:when test="${reviewLists.point == 3}">
						<img src="/img/star_fill.png" alt="이미지" width="20" height="20">		
					</c:when>
					<c:otherwise>
						<img src="/img/star_empty.png" alt="이미지" width="20" height="20">
					</c:otherwise>
				</c:choose> 
		</div>
			<fmt:formatDate value="${reviewLists.createdAt}" pattern="yyyy년 M월 d일" var="pattern1" />
			<small class="text-secondary">${pattern1}</small>
			<div>${reviewLists.review}</div>
			<div>${reviewLists.menu}</div>
		</div>
	</c:forEach>
	<hr>