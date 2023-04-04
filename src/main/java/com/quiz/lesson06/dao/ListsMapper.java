package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Lists;

@Repository
public interface ListsMapper {

	
	// output: void        input : title, url
	public void insertLists (
			@Param("name") String name,
			@Param("url") String url);
	
	
	
	// ouput: List<lists>    input: x
	public List<Lists> selectLists();
	
}
