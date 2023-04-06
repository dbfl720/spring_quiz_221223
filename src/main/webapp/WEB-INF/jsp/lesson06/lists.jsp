<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 추가하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery  원본 필요  --%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<h1>즐겨 찾기 추가하기</h1>
	<div>제목</div>
	<input id="name"  type="text" class="form-control col-12 mb-3">
	<div>주소</div>
	<div class="d-flex form-inline">
		<input id="url"  type="text" class="form-control col-10 mb-3">
		<button id="urlCheckBtn" type="button" class="btn btn-info form-control col-1 ml-2">중복확인</button>
	</div>
	<small id="isDuplicationText" class="text-danger d-none">중복된 URL 입니다.</small>
	<small id="availableUrlText" class="text-success d-none">저장 가능한 URL 입니다.</small>
	<div><input type="button" id="addBtn" class="btn btn-success form-control col-12 mb-3" value="추가"></div>
</div>


	
	<script>
	// 항상 jsp 콘솔 창 켜서 확인! 
		$(document).ready(function() {
			
			// 추가버튼
			 $("#addBtn").on("click", function() {   // click - 이벤트 이름 
				//alert("??");
				
				// validation
				let name = $("#name").val().trim();    // val() - value
				let url = $("#url").val().trim();
				
				if (!name) {       // (name == "") 
					alert("제목을 입력하세요.");
					return;
				}
				
				if (!url) {
					alert("주소를 입력하세요.");
					return;      // return - 빠져나가기 // 아래 코드 실행 안되게 . 
				}
				
				
				// http도 아니고 https도 아닐 때 잘못된 주소 
				 if (url.startsWith("http://") == false && url.startsWith("https://") == false) {
					alert("http:// 또는 https:// 입력해주세요.");
					return;
				} 
				
				
				
				 console.log($("#urlStatusArea").children().length);
					// 0: 거짓(중복x)   그 외 : 참 (중복)
					if ($("#urlStatusArea").children().length == 0) {// ???????? 중복이 아닌데도 서버호출 불가가 됨. colse도 1이 나옴... ?
						alert("서버호출 가능");  
						 
					
					}  else {  
						alert("서버호출 불가"); 
							return;
					}
				
				
			
				console.log(name);
				console.log(url); 
				
				
		
				
				
			
				
				// AJAX: 폼태그와 상관없이 비동기로 별도 요청 (Request)
				  $.ajax({
				// request
					type:"POST"
					, url:"/lesson06/quiz01/add_lists"       // postMapping  주소 쓰기. 
					, data:{"name":name, "url":url}          // "name" - id명 (왼쪽) // name(오른쪽) - 변수
				
				
				// response
					,success:function(data) {     // data는 변수임. 위에 data와 연관 없음.  // "{"code":1,    "result":"성공"}" // 내부적으로 string임에도 불구하고 파싱을 해서 key, value로 구별해줌. //  jquery ajax 함수가 json string을 object로 파싱해줌. 
						//alert(data.code);
						//alert(data.result);
						
						if(data.code == 1) {
							location.href="/lesson06/quiz01/result_view";
						}  else {
							alert(data.errorMessage);  // 에러는 없는데 로직상 문제. (성공이면서 로직문제)
						}
						
					}
					
					, error:function(request, status, error) {
						alert("요청에 실패했습니다. 관리자에게 문의해주세요.");  // ajax 요청도 안되는 경우. 
						
					}
					
					
				}); 
				
			});  // 추가버튼
			 
			 
			
			
			
			
			
			
			
			 
			// 중복 확인 버튼
				$("#urlCheckBtn").on('click', function() {
					// #addressStatusArea 하위 태그들을 초기화
					$("#urlStatusArea").empty();
					
					let url = $("#url").val().trim();
					
					// validation
					if (url == "") {
						alert("검사할 url을 입력하세요.");
						return;
					}
					
					
					
					// 주소 중복됐는지 체크 -> AjAX 통신   
					$.ajax({
						// request
						type:"POST"  // post로 하는게 좋음 - 주소길이 제한이 있기 때문에... 
						, url:"/lesson06/quiz01/is_duplication"
						, data:{"url":url}  // "" - db 컬럼명과 일치하는게 좋음. 
						
					
					
						// response
						, success:function(data) {  // key, value 형태로 옴. String.  // 위에 data와 달름.
							// {"isDuplication":true}
							if (data.isDuplication) {
								// 중복
								$("#isDuplicationText").removeClass("d-none");
								$("#availableUrlText").addClass("d-none");
							} else {
								// 중복 아님 => 사용 가능.
								$("#isDuplicationText").addClass("d-none");
								$("#availableUrlText").removeClass("d-none");
							}
							
						}
						
						, error:function(request, status, error) {   // 서버에서 에러가 발생했을 때 . 
							alert("중복확인에 실패했습니다. 관리자에게 문의해주세요.");
						}
						
					});
					
				}); // 중복 확인 버튼
			
			
				
		});
	</script>

</body>
</html>