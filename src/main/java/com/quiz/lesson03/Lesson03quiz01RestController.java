package com.quiz.lesson03;

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
	
	
	//http://localhost/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public Estate quiz01_1 (
		@RequestParam(value="id") int id
		) {
		return estateBO.getEstateById(id);
	}
		
	@RequestMapping("/2")
	public Estate quiz01_2 (
		@RequestParam(value="rent_price") Integer rent_price
		) {
		return estateBO.getEstateByRent_Price(rent_price);
	}
}
