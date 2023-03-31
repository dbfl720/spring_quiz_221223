<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<h3 class="mt-4 font-weight-bold">과거 날씨</h3>
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${weatherHistory}" var="weatherPast">
						<tr>
							<td>${weatherPast.date}</td>
							<td>
								<c:choose>
									<c:when test="${fn:startsWith(weatherPast.weather, '비')}">
										<img src="/img/rainy.jpg" alt="날씨 이미지" width="40" height="40" >
									</c:when>
									<c:when test="${fn:startsWith(weatherPast.weather, '흐림')}">
										<img src="/img/cloudy.jpg" alt="날씨 이미지" width="40" height="40" >
									</c:when>
									<c:when test="${fn:startsWith(weatherPast.weather, '맑음')}">
										<img src="/img/sunny.jpg" alt="날씨 이미지" width="40" height="40" >
									</c:when>
									<c:otherwise>
								    	<img src="/img/partlyCloudy.jpg" alt="날씨 이미지" width="40" height="40" >
									</c:otherwise>
								</c:choose>
							</td>
							<td>${weatherPast.temperatures}℃</td>
							<td>${weatherPast.precipitation}mm</td>
							<td>${weatherPast.microDust}</td>
							<td>${weatherPast.windSpeed}km/h</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			