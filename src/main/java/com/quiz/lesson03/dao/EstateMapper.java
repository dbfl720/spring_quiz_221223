package com.quiz.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.Estate;

@Repository
public interface EstateMapper {
	
	public Estate selectEstateById(@Param("id") int id); // BO 메소드명 복사해서 select로 수정해서 써랏! 
	
	public Estate selectEstateByRent_Price(@Param("rent_price") Integer rent_price);
}
