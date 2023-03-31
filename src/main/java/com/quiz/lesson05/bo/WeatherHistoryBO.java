package com.quiz.lesson05.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.WeatherMapper;
import com.quiz.lesson05.model.WeatherHistory;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherMapper weatherMapper;
	
	// input:x   output: List<WeatherHistory> 
	public List<WeatherHistory> getWeather() { 
		return weatherMapper.selectWeather();  // ** Mapper 연결
	}
	
	
	// output: x   // input: weatherHistory 
	public void addWeather(WeatherHistory weatherHistory) { 
		weatherMapper.insertWeather(weatherHistory);  // ** Mapper 연결  // 순서도 체크해야됨 param 했으면.
			
	}		
	
}
