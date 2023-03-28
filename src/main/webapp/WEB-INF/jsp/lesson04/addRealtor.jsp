<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공인중개사 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>공인중개사 추가</h1>
		<form method="post" action="/lesson04/quiz02/add_realtor"> <!-- 이 주소가 insert 해줌. -->
			<div class="form-group">
				<div>
					상호명
					<input type="text" name="office" class="form-control col-8"> <!-- name : request파라미터로 넘어가는 것임. -->
				</div>
			</div>
			<div class="form-group">
				<div>
					전화번호
					<input type="text" name="phoneNumber" class="form-control col-8">
				</div>
			<div class="form-group">
				<div>
					주소
					<input type="text" name="address" class="form-control col-8">
				</div>
			</div>
			<div class="form-group">
				<div>
					등급
					<input type="text" name="grade" class="form-control col-8">
				</div>
			</div>
		
			<button type="submit" class="btn btn-info">추가</button>
		</form>
	</div>
</body>
</html>