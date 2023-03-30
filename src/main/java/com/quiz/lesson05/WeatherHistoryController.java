package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@GetMapping("/weatherHistory")
	public String WeatherHistory() {
		return "/weather/weatherHistory";
	}
	
}
