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
	public List<Estate> quiz01_2 (@RequestParam(value="rentPrice") Integer rentPrice){
		List<Estate> estateList = estateBO.getEstateListByRentPrice(rentPrice); // BO 연결
		return estateList;
	}
	
	
	
	@RequestMapping("/3")
	public List<Estate> quiz01_3 (
			@RequestParam(value="area") int area,
			@RequestParam(value="price") int price
			) {
		List<Estate> estateList = estateBO.getEstateListByAreaAndPrice(area, price); // ** BO연결
		return estateList;
	}
	
}
