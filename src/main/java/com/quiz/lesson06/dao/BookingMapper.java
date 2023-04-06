package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Booking;

@Repository
public interface BookingMapper {
	
	// select
	public List<Booking> selectBookingList();
	
	
	
	// delect
	public int deleteBookingById(int id);
	
	
	// insert
	public int insertBooking(
			@Param("name") String name,
			@Param("headcount") int headcount,
			@Param("day") int day, 
			@Param("date") String date, 
			@Param("phoneNumber") String phoneNumber,
			@Param("state") String state);
	
	
	
	// select
	public Booking selectBookingListByField(  // 한 행만 필요하기 때문에 Booking. 
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}
