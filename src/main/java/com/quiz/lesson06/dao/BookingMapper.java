package com.quiz.lesson06.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Booking;

@Repository
public interface BookingMapper {
	
	// output: List<booking>   input: x
	public List<Booking> getBookingList();
	
	
	
}
