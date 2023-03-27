package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired 
	private RealtorBO realtorBO;
	
	// localhost:8080/lesson04/quiz02/add_realtor_view
	@GetMapping("/add_realtor_view") // 이 주소로 들어오면
	public String addRealtorView() {
		return "lesson04/addRealtor"; // 이 주소로 보여준다. jsp
	}
	
	
	// 1. jsp먼저 만들어서 return 디버깅 확인 
	// 2. 한줄씩 보면서 breakpoint 디버깅 확인
	// localhost:8080/lesson04/quiz02/add_realtor
	@PostMapping("/add_realtor")  // control +shit + r -> 검색
	public String addRealtor() {
		
		
		// db insert   // breakpoint 
		
		// db select - id 
		
		// model 결과 담음
		
		// view 이동
		return "lesson04/afterAddRealtor"; //  breakpoint 
	}
}
