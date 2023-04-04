
<div align=center><h1>💻 STACKS</h1></div>



<div align=center>
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=black">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> 
 <br>

<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white">
<br>
<img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=for-the-badge&logo=Apache Tomcat&logoColor=black">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white">
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=black">
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=black">

</div>
<br><br><br><br><br><br><br><br><br>







# 🌿 JSTL를 이용한 배탈의 민족 사이트 만들기<br><br>


https://user-images.githubusercontent.com/116433637/229697944-b207c715-e58f-4354-8ced-a0dbcfcb076e.mp4


<br><br><br>

![스크린샷 2023-04-04 오후 2 38 19](https://user-images.githubusercontent.com/116433637/229698003-667d9d85-b5e2-4108-b739-178e894108f4.png)


<br><br><br>

![스크린샷 2023-04-04 오후 2 38 37](https://user-images.githubusercontent.com/116433637/229698050-00e262f2-a9bf-4044-93bf-0ccf0427a52f.png)


<br><br><br>



### 🌿<b>JSTL를 이용해 사용한 기능</b>

> 1. 우리동네 가게 리스트 페이지 <br>
> store table 을 활용해서 아래와 같은 페이지를 만드세요. <br>
> 2강 DB 연동(MyBatis) 에서 사용한 StoreBO 를 활용하세요. <br>
> 2. 리뷰 페이지 <br>
> 1번 문제에서 만든 리스트에서 가게를 선택 했을때, 해당 가게의 리뷰를 보여주는 페이지를 만드세요. <br>
> new_review table을 활용하세요. <br>
> get method의 parameter를 활용해서 링크로 store 정보를 전달하세요. <br>
> hint ) /test06/reviews?storeId=3&storeName=BHC <br>
> 최근 날짜 순서로 출력하세요 <br>
> 별 이미지를 활용해서 point 에 따른 별점을 표시하세요. <br>
> 리뷰 내용이 없는 경우 아래와 같이 안내하도록 하세요. <br>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>






# 🌿 JSTL를 이용한 기상청 사이트 만들기<br><br>

https://user-images.githubusercontent.com/116433637/229274546-4e3c00b2-9895-4117-a7a3-493903d98424.mp4

<br><br><br>

![스크린샷 2023-04-01 오후 5 14 36](https://user-images.githubusercontent.com/116433637/229274623-0561936b-2507-4dd4-8c31-35aec6d766ac.png) 

<br><br><br>

![스크린샷 2023-04-01 오후 5 14 51](https://user-images.githubusercontent.com/116433637/229274624-c818a4f1-37dd-4699-b41d-6036adac464b.png) <br><br>



### 🌿<b>JSTL를 이용해 사용한 기능</b>

> 1. 날씨 정보 페이지
> weather_history table 을 활용해서 아래와 같은 페이지를 만드세요. <br>
> jstl 을 활용해서 날짜 포멧을 맞춰서 출력하세요. <br>
> 기상청 로고는 인터넷에서 이미지 링크를 구해서 사용하세요. <br>
> 날씨에 맞는 이미지를 표시하세요.  <br>
> 2. 날씨 입력 페이지 <br>
> 날씨 정보를 입력 받고 DB에 저장 하는 아래와 같은 페이지를 만드세요. <br>
> 입력이 성공한 뒤에는 위에서 만든 날씨 정보 페이지로 redirect 시키세요. <br>
> datepicker 라이브러리를 사용해보세요. <br>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>




#  🌳 에러 코드
org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors Field error in object 'weatherHistory' on field 'date': rejected value [2023-04-19]; codes [typeMismatch.weatherHistory.date,typeMismatch.date,typeMismatch.java.util.Date,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [weatherHistory.date,date]; arguments []; default message [date]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'date'; nested exception is org.springframework.core.convert.ConversionFailedException: **Failed to convert from type [java.lang.String] to type [java.util.Date] for value '2023-04-19'; nested exception is java.lang.IllegalArgumentException]**


 <br><br>
 
 

* 🌾 원인 : DB - date 타입이고, view - String 타입으로 요청이 되기 때문에 변환하는 과정에서 충돌.

* 🌾 해결 방법 : model에서 저장할 때, 필드를 String 타입으로 변환. DB에서는 내부적으로, 저장할때 String 타입 -> Date 타입으로 변환된다.  view로 보여줄 때는, model - 필드가 String이기 때문에 String으로 보여진다. <br>

 

* 정리 * 

String(view) -> date(DB) -> date (select) // DB에서는 date이지만, 저장할때 String 타입으로 하면, DB에서 date객체로 저장됨. <br>

 <br><br>
**<전>** <br>
![스크린샷 2023-04-01 오전 10 31 35](https://user-images.githubusercontent.com/116433637/229264373-69f5bee8-e89d-4cc3-b7b6-27d514067d21.png)<br>
![스크린샷 2023-04-01 오전 10 06 30](https://user-images.githubusercontent.com/116433637/229264376-58652f80-64a8-4f32-9dc1-018ef978f2ac.png)

 <br><br>

**<후>** <br>
![스크린샷 2023-04-01 오후 12 48 01](https://user-images.githubusercontent.com/116433637/229264409-31ff5d9b-6105-46c5-96d1-74cbdd4a2145.png)

 <br>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>




















#  🌳 에러 코드
Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Mar 31 11:35:23 KST 2023

There was an unexpected error (type=Internal Server Error, status=500).

nested exception is org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 14


 <br><br>
 
 


* 🌾 원인 :List로 담아서 output을 해야하는데 한 행으로 output을 했기에 TooManyResultsException 발생.

* 🌾 해결 방법 : BO, Mapper, controller 메소드들을 ,  output을 list로 만든다. 

 <br><br>
<전> <br>

![스크린샷 2023-03-31 오후 12 00 36](https://user-images.githubusercontent.com/116433637/229156419-dc39b0ae-57d2-4291-85fe-51d4b0d989e5.png) <br><br>

<후> <br>
![스크린샷 2023-03-31 오전 11 59 08](https://user-images.githubusercontent.com/116433637/229156492-b8903e63-3c94-46d0-a354-677e2b070aae.png) <br>
![스크린샷 2023-03-31 오전 11 59 48](https://user-images.githubusercontent.com/116433637/229156502-1a57900f-7faa-4b60-be90-4cf01b6851ea.png)<br>
![스크린샷 2023-03-31 오전 11 59 28](https://user-images.githubusercontent.com/116433637/229156506-e7f3ecc8-b5e6-400e-94d2-dccc5e06b591.png)<br>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>








#  🌳 에러 코드
* 🌾 에러  - model.addAttribute() 값이 넘어오지 않고 null로 됨.

 ![스크린샷 2023-03-28 오후 3 17 35](https://user-images.githubusercontent.com/116433637/228150689-2383920a-a014-4dc9-b205-1ae55d19548e.png)

 <br><br>
 
 


* 🌾 원인 : .xml에 백틱 대신에 '' 작은따음표를 적용.

* 🌾 해결 방법 : 백틱으로 수정.

 <br><br>

 ![스크린샷 2023-03-28 오후 3 16 43](https://user-images.githubusercontent.com/116433637/228149926-7b9758c7-214b-4293-ba2b-6d3fb8a82ee5.png)
 <br><br>
 ![스크린샷 2023-03-28 오후 3 47 38](https://user-images.githubusercontent.com/116433637/228151702-a790252e-d389-431f-9998-b09591717cfa.png)
  <br><br>
![스크린샷 2023-03-28 오후 3 19 35](https://user-images.githubusercontent.com/116433637/228150700-2e506090-8a11-4145-8b27-c87d091a046f.png)

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>








#  🌳 에러 코드

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun Mar 26 22:06:03 KST 2023

There was an unexpected error (type=Internal Server Error, status=500).

Failed to parse the expression [${}]

javax.el.ELException: Failed to parse the expression [${}]

 <br><br>
 
 

 
2023-03-26 22:06:03,877 DEBUG [org.springframework.web.servlet.DispatcherServlet] Failed to complete request: org.apache.jasper.JasperException: org.apache.jasper.JasperException: javax.el.ELException: Failed to parse the expression [${}]

2023-03-26 22:06:03,878 ERROR [org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/].[dispatcherServlet]] Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [org.apache.jasper.JasperException: javax.el.ELException: Failed to parse the expression [${}]] with root cause

org.apache.el.parser.ParseException: Encountered " "}" "} "" at line 1, column 3.

<br><br>


* 🌾 원인 : 주석 부분에 ${} 쓰여져 있었음.

* 🌾 해결 방법 : ${} 제거.

 <br><br>
 
![스크린샷 2023-03-26 오후 10 16 37](https://user-images.githubusercontent.com/116433637/227837090-bfc95a6e-07d9-4800-8cce-ffafaf3a8c22.png)<br><br>
![스크린샷 2023-03-26 오후 10 18 39](https://user-images.githubusercontent.com/116433637/227837092-194da59b-b625-4ddc-94c4-60761f362e3c.png)

<br><br><br><br><br>
