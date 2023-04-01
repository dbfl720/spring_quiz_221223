package com.quiz.lesson05.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

// not null -> 타입을 소문자로 씀! ex) int, dounble. float..
public class WeatherHistory {

		private int id;
		//@DateTimeFormat(pattern = "yyyy-MM-dd")  
		private String date;			// String(view) -> date(DB) -> date (select) // DB에서는 date이지만, 저장할때 String 타입으로 하면, DB에서 date객체로 저장됨.
		private String weather;
		private float temperatures;
		private float precipitation;
		private String microDust;
		private float windSpeed;
		private Date createdAt;
		private Date updatedAt;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getWeather() {
			return weather;
		}
		public void setWeather(String weather) {
			this.weather = weather;
		}
		public float getTemperatures() {
			return temperatures;
		}
		public void setTemperatures(float temperatures) {
			this.temperatures = temperatures;
		}
		public float getPrecipitation() {
			return precipitation;
		}
		public void setPrecipitation(float precipitation) {
			this.precipitation = precipitation;
		}
		public String getMicroDust() {
			return microDust;
		}
		public void setMicroDust(String microDust) {
			this.microDust = microDust;
		}
		public float getWindSpeed() {
			return windSpeed;
		}
		public void setWindSpeed(float windSpeed) {
			this.windSpeed = windSpeed;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		
		
	
		
}
