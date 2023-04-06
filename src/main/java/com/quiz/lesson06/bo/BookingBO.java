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
		return bookingMapper.selectBookingListByField(name, phoneNumber);
	}
}
