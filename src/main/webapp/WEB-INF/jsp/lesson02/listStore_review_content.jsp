<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		

<c:if test="${empty reviewList}">
	<c:forEach items="${storeName}" var="storeNames">
		<div class="display-4 mt-4 mb-4">${storeNames} - 리뷰</div>
	</c:forEach>
		<h1 class="mt-5 text-center">작성된 리뷰가 없습니다.</h1>
</c:if>

<c:if test="${not empty reviewList}">
	<c:forEach items="${storeName}" var="storeNames">
		<div class="display-4 mt-4 mb-4">${storeNames} - 리뷰</div>
	</c:forEach>
		<c:forEach items="${reviewList}" var="reviewLists">
				<div class="sectionBox mb-4">
				<div class="d-flex">
					<h3>${reviewLists.userName}</h3>
					<%-- 별 표시 --%>
					<div class="ml-3 mt-1">
						<c:set var="point" value="${reviewLists.point}" /> <%-- 변수 설정. --%>
						<c:forEach begin="1" end="5">
							<c:choose>
								<c:when test="${point > 0.5}">
									<img src="/img/star_fill.png" alt="이미지" width="20" height="20">
									<c:set var="point" value="${point - 1}" /> <%-- 변수값 재설정. --%>
								</c:when>
								<c:when test="${point == 0.5}">
									<img src="/img/star_half.png" alt="이미지" width="20" height="20">
									<c:set var="point" value="${point - 0.5}"/> <%-- 변수값 재설정. --%>
								</c:when>
								<c:when test="${point == 0}">
									<img src="/img/star_empty.png" alt="이미지" width="20" height="20">
								</c:when>	
							</c:choose>
						</c:forEach>
					</div>							
				</div>
				
					<fmt:formatDate value="${reviewLists.createdAt}" pattern="yyyy년 M월 d일" var="pattern1" />
					<small class="text-secondary">${pattern1}</small>
					
					<div>${reviewLists.review}</div>
					<span class="menuBox">${reviewLists.menu}</span>
				</div>
	</c:forEach>
</c:if>
