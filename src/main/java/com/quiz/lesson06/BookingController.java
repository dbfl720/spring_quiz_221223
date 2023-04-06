package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@RequestMapping("/lesson06/booking")
@Controller
public class BookingController {

	
	@Autowired
	private BookingBO bookingBO;
	
	
	// localhost:8080/lesson06/booking/booking_view
	@GetMapping("/booking_view")
	public String bookingView(Model model) {
		
		// select DB
		List<Booking> booking = bookingBO.getBookingList();
		model.addAttribute("booking", booking);
		
		return "lesson06/booking";
	}
	
	
	
	
	
	// id로 삭제 API
	// AJAX 요청
	// localhost:8080/lesson06/booking/delete_booking
	@PostMapping("/delete_booking")
	@ResponseBody
	public Map<String, Object> deleteBooking (
			@RequestParam("id") int id) {
		
		// delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		
		if (rowCount > 0) {
			result.put("code", 1);  // 1: 성공
			result.put("result", "성공");
		} else {
			result.put("code", 500);    // 500: 에러
			result.put("errorMessage", "삭제하는데 실패했습니다.");
		}
		
		return result;
	}
	
}
