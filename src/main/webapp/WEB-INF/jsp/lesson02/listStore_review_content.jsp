<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		
			<c:forEach items="${reviewList}" var="reviewLists">
		<div class="sectionBox mb-4">
		<div class="d-flex ml-3">
			<c:choose>
				<c:when test="${reviewLists.point == 1}">
					<h3>${reviewLists.userName}</h3><img src="/img/star_fill.png" alt="이미지" width="20" height="20">
							
				</c:when>
				<c:otherwise>
					<h3>${reviewLists.userName}</h3><img src="/img/star_empty.png" alt="이미지" width="20" height="20">
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