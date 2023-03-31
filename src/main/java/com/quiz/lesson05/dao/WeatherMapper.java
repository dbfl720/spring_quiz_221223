package com.quiz.lesson05.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.WeatherHistory;

@Repository
public interface WeatherMapper {

	// select
	public List<WeatherHistory> selectWeather();
	
	
	// insert 
	public void insertWeather (WeatherHistory weatherHistory);
	
}
