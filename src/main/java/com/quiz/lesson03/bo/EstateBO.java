package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.EstateMapper;
import com.quiz.lesson03.model.Estate;

@Service
public class EstateBO {

	
	@Autowired
	private EstateMapper estateMapper;
	
	// input : id      output: estate객체.
	public Estate getEstateById(int id) {  // BO에서 select할때는 메소드명이 get으로 해야됨!! input있을 경우는 메소드명 (By + 컬럼명) 해야됨!! 
		return estateMapper.selectEstateById(id);
	}
	
	public Estate getEstateByRent_Price(Integer rent_price) {  // BO에서 select할때는 메소드명이 get으로 해야됨!! input있을 경우는 메소드명 (By + 컬럼명) 해야됨!! 
		return estateMapper.selectEstateByRent_Price(rent_price);
	}
}
