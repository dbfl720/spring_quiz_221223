package com.quiz.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.ReviewMapper;
import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.model.Store;
import com.quiz.lesson02.model.new_review;

@Service 
public class ReviewBO {
	
	@Autowired // @Autowired 해당하는 Spring Bean을 찾아 사용할 수 있도록 한다. DI(Depency Injection) 의존성 주입이라고 한다.
	private ReviewMapper reviewMapper;   
	
	
	// ouput: List<new_review>     //   input:  storeId
	public List<new_review> getReviewList(int storeId) {
		return reviewMapper.selectReviewList(storeId);
	}
	
	
}
