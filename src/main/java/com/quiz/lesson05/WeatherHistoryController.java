package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	// localhost:8080/weather/weatherHistory_layout
	@GetMapping("/weatherHistory_layout")
	public String WeatherHistory(Model model) {
		
		// DB Select
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
	
	
	
	
	// localhost:8080/weather/weatherHistory_insert_layout
	@PostMapping("/weatherHistory_insert_layout")
	public String WeatherHistory_insert(
			@ModelAttribute WeatherHistory weatherHistory,
			Model model) {
		
		// insert DB
		weatherHistoryBO.addWeather(weatherHistory);
		// model 데이터 담기
		model.addAttribute("weatherHistory", weatherHistory); // ""안에 값은 jsp로 보내질 값. (el문법) // ("")안에 명칭은 아무거나 해도 됨.
		
		// view 이동
		return "weather/weatherHistory_layout";
	}
}
