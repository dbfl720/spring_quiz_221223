#  🌳 에러 코드

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun Mar 26 22:06:03 KST 2023

There was an unexpected error (type=Internal Server Error, status=500).

Failed to parse the expression [${}]

javax.el.ELException: Failed to parse the expression [${}]

 
 
 

 
2023-03-26 22:06:03,877 DEBUG [org.springframework.web.servlet.DispatcherServlet] Failed to complete request: org.apache.jasper.JasperException: org.apache.jasper.JasperException: javax.el.ELException: Failed to parse the expression [${}]

2023-03-26 22:06:03,878 ERROR [org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/].[dispatcherServlet]] Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [org.apache.jasper.JasperException: javax.el.ELException: Failed to parse the expression [${}]] with root cause

org.apache.el.parser.ParseException: Encountered " "}" "} "" at line 1, column 3.

<br><br>


* 🌾 원인 : 주석처리 부분에 ${} 쓰여져 있었음.

* 🌾 해결 방법 : ${} 제거.

 <br><br>
 
![스크린샷 2023-03-26 오후 10 16 37](https://user-images.githubusercontent.com/116433637/227837090-bfc95a6e-07d9-4800-8cce-ffafaf3a8c22.png)
![스크린샷 2023-03-26 오후 10 18 39](https://user-images.githubusercontent.com/116433637/227837092-194da59b-b625-4ddc-94c4-60761f362e3c.png)

<br><br><br><br><br>
