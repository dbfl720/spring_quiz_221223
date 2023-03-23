package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.model.Estate;


@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {

	@Autowired
	private EstateBO estateBO;
	
	// 객체로 insert하기
	// localhost:8080/lesson03/quiz02/1
	// 데이터 베이스 확인,콘솔 확인 필수! 
	// 흐름에 맞춰서 코드 짜는게 좋음.
	@RequestMapping("/1")
	public String quiz02_1() {
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int rowCount = estateBO.addEstate(estate); //*BO 연결 // 입력성공한 행의 개수가 넘어감. 
		
		return "입력 성공 :" + rowCount;
	}
	
	
	// field로 insert하기
	// localhost:8080/lesson03/quiz02/2
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam ("realtorId") int  realtorId) {  // realtorId만 parameter롤 통해서 전달. //필수 파라미터  두개이상일때는 value써야됨,하나일때는 value생략.
		int rowCount = estateBO.addEstateAsField( realtorId,"썅떼빌리버 오피스텔 814호",45,"월세",100000,120); // **BO 연결, //입력 성공한 한 행의 개수가 저장.
		return "입력 성공: " + rowCount;
	}
}
