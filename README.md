

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



<br><br><br><br><br>








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
