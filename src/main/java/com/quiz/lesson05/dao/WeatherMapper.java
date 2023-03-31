package com.quiz.lesson05.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.WeatherHistory;

@Repository
public interface WeatherMapper {

	// select
	public List<WeatherHistory> selectWeather();
	
	
	// 파라미터가 여러개이면 한줄 씩 하는게 좋음.
	// insert 
	public void insertWeather (WeatherHistory weatherHistory);
	
}
