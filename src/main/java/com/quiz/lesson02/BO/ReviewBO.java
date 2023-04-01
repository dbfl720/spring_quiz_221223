package com.quiz.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.ReviewMapper;
import com.quiz.lesson02.model.new_review;

@Service 
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;   
	
	// ouput:  getReviewList()  i   nput:  x 
	public List<new_review> getReviewList() {
		return reviewMapper.selectReviewList();   //**Mapper 연결
	}
}
