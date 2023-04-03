package com.quiz.lesson02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;
import com.quiz.lesson02.model.new_review;


@Repository
public interface ReviewMapper {

	public List<new_review> selectReviewList(
			@Param("storeId") int storeId,
			@Param("name") String name);
	

}
