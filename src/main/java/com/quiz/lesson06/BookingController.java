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
	
	// delete
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
	
	
	
	
	// insert
	// localhost:8080/lesson06/booking/booking_insert_view
	@GetMapping("/booking_insert_view")
	public String bookingInsertView(Model model) {
		
		// select DB
//		List<Booking> booking = bookingBO.getBookingInsertList();
//		model.addAttribute("booking", booking);
		
		return "lesson06/booking_insert_layout";
	}
	
	
	
	
	
	
	// 예약하기 API
	// AJAX 요청
	// localhost:8080/lesson06/booking/insert_booking
	@ResponseBody
	@PostMapping("/insert_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") String date,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("state") String state){
				// {"code":1, "result":"성공"}
				// {"code":500, "errorMessage":"추가하는데 실패했습니다."}
				
		
		
				// insert
				int rowCount = bookingBO.addBooking(name, headcount, day, date, phoneNumber, state);
				
				Map<String, Object> result = new HashMap<>();
				if(rowCount > 0) {
					result.put("code", 1);
					result.put("result", "성공");
				} else {
					result.put("code", 500);
					result.put("errorMessage", "데이터를 추가하는데 실패했습니다.");
				}
				return result;    // JSON String
			}
	
	
	
	
	
	
	// select
	// localhost:8080/lesson06/booking/booking_select_view
	@GetMapping("/booking_select_view")
	public String bookingSelectView() {
		
		// select DB
//		List<Booking> booking = bookingBO.getBookingListByField(name, phoneNumber);
//		model.addAttribute("booking", booking);
		
		return "lesson06/booking_select_layout";
	}
	
	
	
	// 조회하기 API 
	// 예약 조회 - AJAX 요청
	// localhost:8080/lesson06/booking/booking_select
	@ResponseBody
	@PostMapping("/booking_select")
	public Map<String, Object> selectBooking (
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Map<String, Object> result = new HashMap<>();
		
		// select DB
		Booking booking = bookingBO.getBookingListByField(name, phoneNumber);
		if (booking == null) {
			result.put("join", "조회 불가");
		} else {
			result.put("name", booking.getName());
			result.put("date", booking.getDate());
			result.put("day", booking.getDay());
			result.put("headCount", booking.getHeadcount());
			result.put("state", booking.getState());
		}
		return result;
		
		
	}
	
}
