package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

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
	
	
	// 1. jsp먼저 만들어서 return 디버깅 확인  - jsp(afterAddRealtor만들고,addRealtor메소드 선언부 만들고 breakpoint 확인
	// 2. 한줄씩 보면서 breakpoint 디버깅 확인 - select DB, model 만들고 breakpoint 
	// localhost:8080/lesson04/quiz02/add_realtor
	@PostMapping("/add_realtor")  // control +shit + r -> 검색 // post방식이라  이 주소로는 바로 못 들어감. 
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
			
		
		// insert DB  
		realtorBO.addRealtor(realtor); // 이 줄만 지나오면 id가 무엇인지 알 수 있다. 내부적으로 insert 됨 //**BO 연결 // breakpoint 
		
		// select DB - id    // 지금 가입한 사람 정보를 db에서 select
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());  //realtor-model안에 id가 있음.//**BO 연결
		
		// model 데이터 담음
		model.addAttribute("realtor",latestRealtor); // ""안에 값은 jsp로 보내질 값. (el문법) // ("")안에 명칭은 아무거나 해도 됨.
		model.addAttribute("title", "공인중개사 정보");
		
		// view 이동
		return "lesson04/afterAddRealtor"; //  breakpoint 
	}
}
