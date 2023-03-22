package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.model.Estate;

@RequestMapping("/lesson03/quiz01")
@RestController  // responsebody 들어가 있음.
public class Lesson03quiz01RestController {
	
	@Autowired
	private EstateBO estateBO;
	
	
	//http://localhost:8080/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public Estate quiz01_1 (
		@RequestParam(value="id") int id
		) {
		return estateBO.getEstateById(id);
	}
		
	@RequestMapping("/2")
	public List<Estate> quiz01_2 (
			@RequestParam(value="rentPrice") int rentPrice){ // 여러건이면 무조건 List !  // null이면 안되서 int. 사실 Integer가 정확함. null 포함되어 있어서.
		return estateBO.getEstateListByRentPrice(rentPrice);  // BO 연결
	}
	
	
	//http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<Estate> quiz01_3 (    // 여러개 결과가 나온다. 혹은 [ ] 가로가 있다. 그러면 무조건 list 
			@RequestParam(value="area") int area,
			@RequestParam(value="price") int price
			) {

		return estateBO.getEstateListByAreaAndPrice(area, price);// ** BO연결
	}
	
}
