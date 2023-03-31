package com.quiz.lesson05.model;

import java.util.Date;

// not null -> 타입을 소문자로 씀! ex) int, dounble. float..
public class WeatherHistory {

		private int id;
		private String date;
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
