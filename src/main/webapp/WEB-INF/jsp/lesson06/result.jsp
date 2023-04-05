<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery  원본 필요  --%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<h1>즐겨 찾기 목록</h1>
	<table class="table text-left">
		<thead>
			
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>

		</thead>
		<tbody>
			<c:forEach items="${list}" var="lists">
				<tr>
					<td>${lists.id}</td>
					<td>${lists.name}</td>
					<td>${lists.url}</td>
					<td>
					<button type="button" class="delBtn btn btn-danger" id="${lists.id}" data-seq="${lists.id}" onclick="remove(this)">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	</div>
	
	

<script>
$(document).ready(function() {
	
	/* // 삭제 버튼
	$(".delBtn").on("click", function(e) {
		let id = $(".delBtn").val()
		//let id = e.target.dataset.id;
		
		
		// AJAX
		$.ajax({
			// request
			type:"POST"
			, url:"/lesson06/quiz01/delete_lists"
			, data:{"id" : id}
		
		
			// response
			, success:function(data) {
				
				if(data == "성공") {
					document.location.reload();
				}
				
				alert(data);
			}
			
			, error:function(request, status, error) {
				alert("요청에 실패했습니다. 관리자에게 문의해주세요.");  // ajax 요청도 안되는 경우. 
				
			}
			
			
		}); // ajax
	}); // 삭제 버튼 */
	
	
	
	function remove(component) {
		$.ajax({
			url:"/lesson06/quiz01/delete_lists"
		   ,type: "DELETE"
		   ,processDate: false
		   ,contentType: false
		   ,data: formDate
		   ,success: function(data) {
			   // 삭제 : 1  else : 0
			   if (data == 1){
				   $(component).remove();
			   }
		   }
		});
	}
	
});  // ready


</script>	

</body>
</html>