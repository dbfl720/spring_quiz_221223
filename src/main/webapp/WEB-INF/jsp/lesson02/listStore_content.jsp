<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="mt-3 mb-3 text-center"><span class="display-4 ">우리동네 가게</span></div>
	<c:forEach items="${store}" var="stores">
		<div class="sectionBox mb-4">
		<h3 class="">${stores.name}</h3>
		<div>전화번호 : ${stores.phoneNumber}</div>
		<div>주소 : ${stores.address}</div>
		</div>
	</c:forEach>
	<hr>
	
	
