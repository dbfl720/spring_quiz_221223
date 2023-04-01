package com.quiz.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	//injection 
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	// 주소단어 마다 _ 쓰는게 좋음.
	// localhost:8080/weather/weatherHistory_layout
	@GetMapping("/weatherHistory_layout")
	public String WeatherHistory(Model model) {
		
		// DB Select		
		// ** list에 담아서 하면 breakpoint 걸어서 잘 보임. 
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeather();
		model.addAttribute("weatherHistory", weatherHistory);
		return "weather/weatherHistory_layout";
	}
	
	
	
	
	// localhost:8080/weather/weatherHistory_insert_layout_view
	@GetMapping("/weatherHistory_insert_layout_view")
	public String WeatherHistory_insert() {
		
		// view 이동
		return "weather/weatherHistory_insert_layout";
	
	}
	
	
	
	
	
	// 컨트롤러는 자기자신 메소드를 부르면 안됨. 무조건, 바깥에서 http 로  요청이 들어와야됨. 
	// 선생님은 @RequestParam이 더 익숙하심. - api팀들이 @RequestParam 다 쓰는걸 좋아함.
	// 400 에러는 파라미터 혹은 보내는주소 받는 주속 확인!!  
	// localhost:8080/weather/weatherHistory_insert_layout
	@PostMapping("/weatherHistory_insert_layout")
	public String WeatherHistory_insert(
			@ModelAttribute WeatherHistory weatherHistory,
			Model model) {  // @DateTimeFormat(pattern="yyyy-MM-dd") Date date 
		
		// insert DB
		weatherHistoryBO.addWeather(weatherHistory);  // insert할 때는 @param 했을 경우, 순서 체크해야됨. 
		// model 데이터 담기
		model.addAttribute("weatherHistory", weatherHistory); // ""안에 값은 jsp로 보내질 값. (el문법) // ("")안에 명칭은 아무거나 해도 됨.
		
		// select x 
		// model x 
		
		// redirect: 목록 페이지 
		return "redirect:/weather/weatherHistory_layout";    // /weather부터 써줘야됨! 위에 requestMapping 부터 ! 
	}
	
	

	

}
