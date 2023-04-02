<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
		
		
 
		
				<%-- 서버에서 가져온 List<String>출력 --%>
					<c:forEach items="${reviewList}" var="reviewLists">
						<div class="sectionBox mb-4">
						<div class="d-flex">
							<h3>${reviewLists.userName}</h3> 
								<div class="ml-3"><c:forEach items="${reviewList}" var="point" step="1" begin="1" end="${reviewLists.point}">	
								<img src="/img/star_fill.png" alt="이미지" width="20" height="20"></c:forEach></div>
								
								<div><c:if test="${reviewLists.point eq 4.5 || reviewLists.point eq 3.5 || reviewLists.point eq 2.5 ||
								  reviewLists.point eq 1.5}">
									<img src="/img/star_half.png" alt="이미지" width="20" height="20"></c:if></div>
								
								<div><c:forEach items="${reviewList}" var="point"  begin="1" end="${5 - reviewLists.point}">	
								<img src="/img/star_empty.png" alt="이미지" width="20" height="20"></c:forEach></div> 
						</div>
							<fmt:formatDate value="${reviewLists.createdAt}" pattern="yyyy년 M월 d일" var="pattern1" />
							<small class="text-secondary">${pattern1}</small>
							<div>${reviewLists.review}</div>
							<div>${reviewLists.menu}</div>
						</div>
					</c:forEach>
		
		<hr>