package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // spring bean
public class Lesson01Quiz03Controller {

	// http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03() {
		//     /WEB-INF/jsp/      lesson01/quiz03.jsp   => view 경로를 리턴하고 있음.
		return "lesson01/quiz03";
	}
}
