package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.RealtorMapper;
import com.quiz.lesson04.model.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorMapper realtorMapper;
	
	public void addRealtor(Realtor realtor) { // insert 하고 돌려주는거 없어서 void // 자료형 객체명 
		
	}
}
