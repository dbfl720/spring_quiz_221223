package com.quiz.lesson01;

// 데이터를 담는 공간
public class Data {
	// 필드
	private String title;
	private String user;
	private String content;
	
	// 메소드
	// 오른쪽 클릭해서 - source - generate getters and setters - select all 이용해서 만들 수 있음.
	
	public String getTitle() {
		return this.title;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getContent() {
		return this.content;
	}
	
	
	public void setData(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	

}
