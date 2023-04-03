<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery  원본 필요  --%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<h1>즐겨 찾기 추가하기</h1>
	<div>제목</div>
	<input id="name" name="name" type="text" class="form-control">
	<div>주소</div>
	<input id="url" name="url" type="text" class="form-control">
	<div><input type="button" id="addBtn" class="btn btn-success form-control" value="추가"></div>

	
	<script>
		$(document).ready(function() {
			$("#addBtn").on("click", function() {
				//alert("??");
				
				// validation
				let name = $("#name").val().trim();
				if (!name) {
					alert("제목을 입력하세요.");
					return;
				}
				
				
				let url = $("#url").val().trim();
				if (!url ) {
					alert("주소를 입력하세요.");
					return;
				}
				/* if (!url.startsWith("http") || !url.startsWith("https")) {
					alert("http 또는 https 프로토콜까지 입력하세요.");
					return;
				} */
				
				
				
				console.log(name);
				console.log(url);
				
				
				/* $.ajax({
				// request
					type:"POST"
					, url:"/lesson06/quiz01/lists"
					, data{"title":title, "url":url}
				
				
				// response
					,success:function(data) {
						
						if(data == "성공") {
							location.href="";
						}
					}
				}); */
				
			});
			
			
		});
	</script>

</body>
</html>