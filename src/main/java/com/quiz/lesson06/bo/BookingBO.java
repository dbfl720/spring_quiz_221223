package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.BookingMapper;
import com.quiz.lesson06.model.Booking;

@Service
public class BookingBO {
	
	
	@Autowired
	private BookingMapper bookingMapper;
	
	
	// select
	// output: List<Booking>    input: x
	public List<Booking> getBookingList() {
		
		return bookingMapper.selectBookingList();
	}
	
	
	// delect
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	
	
	// insert
	public int addBooking(String name, int headcount, int day, String date, String phoneNumber, String state) {
		return bookingMapper.insertBooking(name, headcount, day, date, phoneNumber, state);
	}
	
	
	
	// select
	public Booking getBookingListByField(String name, String phoneNumber) {   // 한 행만 필요하기 때문에 Booking. 
		// 원래 BO에서 가공 많이함!!! 
		// ** Booking - 없으면 null  // List - 없으면 []
		// 선생님 코드.
		List<Booking> bookingList = bookingMapper.selectBookingListByField(name, phoneNumber);
		// [1 3 7\     - 7번만 줘야 된다. 즉 마지막 꺼를 준다.
		// x  - 없을 때도 체크 
		// 7 - 1개면 한개만 주면 됨.
		
		if (bookingList.isEmpty()) {
			return null;
		}
		
		// 비어있지 않으면 값이 있고, 마지막 인덱스에 있는 값을 돌려준다. (최신값)
		return bookingList.get(bookingList.size() - 1);
	}
}
