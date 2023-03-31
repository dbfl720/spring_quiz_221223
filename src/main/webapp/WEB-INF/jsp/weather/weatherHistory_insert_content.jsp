<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<h1>날씨 입력</h1>
	<form method="post" action="/weather/weatherHistory_insert_layout">  <%-- 이 주소가 insert. postMatting 주소가 여기 들어감.--%>
		
		<div class="d-flex justify-content-between align-items-center">
		<div class="d-flex"> 날짜 <input name="date" type="text" class="form-control col-10 ml-2" ></div>
		<div class="d-flex ml-3"> 날씨
			<select name="weather" id= "weather" class="d-flex form-select-sm form-control form-select ml-2"> <%-- name은 필드명과 같아야 한다. --%>
						<option  value="맑음">맑음</option>			
						<option  value="비">비</option>			
						<option  value="흐림">흐림</option>			
						<option  value="구름조금">구름조금</option>					
			</select> 
		</div>
		<div class="d-flex ml-3"> 미세먼지
			<select name="microDust" id= "microDust" class="d-flex form-select-sm form-control form-select ml-2">
						<option value="좋음">좋음</option>			
						<option value="보통">보통</option>			
						<option value="나쁨">나쁨</option>			
						<option value="최악">최악</option>					
			</select> 
		</div>
		</div>
		
		<div class="d-flex justify-content-between align-items-center">
			<div class="input-group"> 기온
				<input id="temperatures" name="temperatures" type="text" class="form-control col-7 ml-2"> <span class="input-group-text " id="basic-addon2">℃</span>
			</div>
			<div class="input-group"> 강수량
				<input id="precipitation" name="precipitation" type="text" class="form-control col-7 ml-2"> <span class="input-group-text " id="basic-addon2">mm</span>
			</div>
			<div class="input-group"> 풍속
				<input id="windSpeed" name="windSpeed" type="text" class="form-control col-7 ml-2"> <span class="input-group-text " id="basic-addon2">km/h</span>
			</div>
		</div>
		<button class="btn btn-secondary"  type="submit">저장</button>
	</form>
	
	
	<%-- jquery는 id로 하는게 편함. --%>
	<%-- 스크립트가 들어가면 무조건 검사를 봐야함.  datepicker  import  해야됨. --%>
	<script> 
		
	</script>