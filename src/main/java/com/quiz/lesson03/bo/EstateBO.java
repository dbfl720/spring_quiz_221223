package com.quiz.lesson03.bo;

import java.util.List;

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
	
	// input: rentPrice    output: List<Estate>
	public List<Estate> getEstateListByRentPrice(int rentPrice) {  // BO에서 select할때는 메소드명이 get으로 해야됨!! input있을 경우는 메소드명 (By + 컬럼명) 해야됨!! 
		return estateMapper.selectEstateListByRentPrice(rentPrice); // ** Mapper 연결
	}
	
	
	// input: area, price     output: List<Estate>
	public List<Estate> getEstateListByAreaAndPrice(int area, int price) {  // ByAreaPrice 해도 됨. 여러개면 And  붙이면 됨.
		return estateMapper.selectEstateListByAreaAndPrice(area, price);
	}
	
	
	// input: Estate  output: int
	public int addEstate(Estate estate) {
		return estateMapper.insertEstate(estate); // *Mapper 연결
	}
	
	
	
	// 	int rowCount = estateBO.addEstateAsField("썅떼빌리버 오피스텔 814호",45,"월세",100000,120);
	public int addEstateAsField(
		    int  realtorId, String address22, 
		    int area22, String type22,
			int price22, Integer rentPrice33) {
		return estateMapper.insertEstateAsField( realtorId, address22, area22, type22, price22, rentPrice33); // ** Mapper연결 // 순서 동일한지 체크해야됨.
	}
	
	
	public int updateEstateById(int id, String type,  int price) { // where절에 들어가는애를 쓴다. 즉 Id
		return estateMapper.updateEstateById(id, type, price);
	}
	
	
	public void deleteEstateById(int id) {
		estateMapper.deleteEstateById(id);
	}
	
}
