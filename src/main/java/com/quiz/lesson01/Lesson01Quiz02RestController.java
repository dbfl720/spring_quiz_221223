package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController // @Controller + @ResponseBody
public class Lesson01Quiz02RestController {
	// @ResponseBody + return String => HttpMessageConverter클래스가 동작을 한다.(스프링프레임워크에 들어있음)    String => response에 글자로 담긴다. text/html
	// @ResponseBody + return 객체 => HttpMessageConverter  ->  jackson 라이브러리를 동작시킨다. => 객체가 JSON String 응답에 담긴다. application/json으로 내려간다.
	
	// 1. 
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();  // heap 영역에 따로 쌓이게.
		map.put("rate",15);
		map.put("director","봉춘호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate",0);
		map.put("director","로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate",12);
		map.put("director","크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate",19);
		map.put("director","윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate",15);
		map.put("director","프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");
		list.add(map);
		
		// map = new HashMap<>();  이렇게 map 이름 안바꾸고 할 수 있음.재활용 가능.
	
		
		return list;
	}
	
	
	
	
	
	
	
	// 2.
	@RequestMapping("/2")
	public List<Data> quiz02_2() {
		List<Data> list = new ArrayList<>();
		Data data = new Data();
		data.setData("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		list.add(data);
		
		data = new Data(); // new를 해서 새로운 내용 추가가능.
		data.setData("헐 대박", "bada", "오늘 목요일이 였어.. 금요일인줄");
		list.add(data);
		
		data = new Data();
		data.setData("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "....");
		list.add(data);
		
		return list; // List -> JSON String으로 변환됨.
		
	}
	
	
	@RequestMapping("/3")  // 요청이 들어오면 주소를 mapping 한다.
	public ResponseEntity<Data> quiz02_3() {
		Data data = new Data();
		data.setData("안녕하세요 가입인사 드립니다.","hagulu","안녕하세요 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
} // class
