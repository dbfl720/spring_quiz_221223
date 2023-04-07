package com.quiz.lesson06;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	// 1. 예약 목록 화면
	// localhost:8080/lesson06/booking/booking_view
	@GetMapping("/booking_view")
	public String bookingView(Model model) {
		
		// select DB
		List<Booking> booking = bookingBO.getBookingList();
		model.addAttribute("booking", booking);
		
		return "lesson06/booking";
	}
	
	
	
	

	
	
	// 1. 예약 삭제 
	// AJAX 요청 
	// localhost:8080/lesson06/booking/delete_booking
	@DeleteMapping("/delete_booking")
	@ResponseBody
	public Map<String, Object> deleteBooking (
			@RequestParam("id") int id) {   // "id"는 ajax에서 data: {"id":id} 여기서 온 파라미터임. ""
		
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
	
	
	
	 // 2. 예약하기 화면
	// insert
	// localhost:8080/lesson06/booking/booking_insert_view
	@GetMapping("/booking_insert_view")
	public String bookingInsertView() {
		
		return "lesson06/booking_insert_layout";
	}
	
	
	
	
	
	// 2. 예약하기 기능
	// 예약하기 API
	// AJAX 요청
	// localhost:8080/lesson06/booking/insert_booking
	@ResponseBody
	@PostMapping("/insert_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,   // ajax에서 넘겨준 key명과 똑같은 파라미터를 쓰는 것임! 
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") @DateTimeFormat (pattern="yyyy-MM-dd") Date date,
			@RequestParam("phoneNumber") String phoneNumber){
				// {"code":1, "result":"성공"}
				// {"code":500, "errorMessage":"추가하는데 실패했습니다."}
				
		
		
				// insert
				int rowCount = bookingBO.addBooking(name, headcount, day, date, phoneNumber);
				
				Map<String, Object> result = new HashMap<>();   // breakpoint
				if(rowCount > 0) {
					result.put("code", 1);
					result.put("result", "성공");
				} else {
					result.put("code", 500);
					result.put("errorMessage", "데이터를 추가하는데 실패했습니다.");
				}
				
				
				
				return result;    // JSON String
			}
	
	
	
	
	
	
	// 3. 예약 조회 하면
	// localhost:8080/lesson06/booking/booking_select_view
	@GetMapping("/booking_select_view")
	public String bookingSelectView() {
		
		return "lesson06/booking_select_layout";
	}
	
	
	
	// 3. 예약 조회 기능
	// 예약 조회 - AJAX 요청
	// localhost:8080/lesson06/booking/booking_select
	@ResponseBody
	@GetMapping("/booking_select")
	public Map<String, Object> selectBooking (
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Map<String, Object> result = new HashMap<>();  // breakpoint // Map은 항상 위에 있어야함. 
		
		//select DB   - TODO  - 구현을 안했는데 해야되는게 있을때 쓰는 것임.select DB
		Booking booking = bookingBO.getBookingListByField(name, phoneNumber);  // 데이터 한개 또는 빵개 받아옴.
		if (booking == null) {
			result.put("join", "조회 불가");
		} else {
			result.put("booking", booking);
//			result.put("name", booking.getName());
//			result.put("date", booking.getDate());
//			result.put("day", booking.getDay());
//			result.put("headCount", booking.getHeadcount());
//			result.put("state", booking.getState());
		}
		return result;
		
		
	}
	
}
