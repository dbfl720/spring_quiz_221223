package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/booking")
@Controller
public class BookingController {

	
	// localhost:8080/lesson06/booking/booking_view
	@GetMapping("/booking_view")
	public String bookingView() {
		
		// select DB
		List<booking> list = ;
		return "lesson06/booking";
	}
	
	
	
	
	
}
