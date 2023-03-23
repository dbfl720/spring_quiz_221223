package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.Estate;

@Repository
public interface EstateMapper {
	
	public Estate selectEstateById(@Param("id") int id); // BO 메소드명 복사해서 select로 수정해서 써랏! 
	
	public List<Estate> selectEstateListByRentPrice( int rentPrice); // 한개일때는 @Param 안쓰는게 나음.
	
	// Mybatis는 파라미터를 단 한개만 보낼 수 있다. 
	// 파라미터가 2개 이상일 때는 하나의 map으로 만들어서 보내야 한다.
	// @Param 을 사용하면 하나의 map으로 만들어준다.
	public List<Estate> selectEstateListByAreaAndPrice(
			@Param("area") int area,  // @Param - 하나의 map으로 구성해주는 어노테이션.
			@Param("price") int price
			);  // 파라미터 여러개이면, 가독성 좋게 하기 위해서 엔터쳐서 코드 작성!. 파라미터 두개이상이면, 

	public int insertEstate(Estate estate); // 하나라서 @Param 안써도 됨.

	
	// @Param이 있기 때문에 하나의 map이 xml로 넘어간다.
	// ** 여기서 중요한 것은 @Param() 안에 있는 단어가 중요 이거는 xml에서 ,#{}에 사용된 이름명임!!!. 옆에는 변수명이라 아무거나 해도됨. 
	public int insertEstateAsField(
			@Param("realtorId") int  realtorId,
			@Param("address") String address33,
			@Param("area") int area33,
			@Param("type") String type55,
			@Param("price") int price11,
			@Param("rentPrice") Integer rentPrice22);
	
	

	public int updateEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	
	
	public void deleteEstateById(int id);
}
