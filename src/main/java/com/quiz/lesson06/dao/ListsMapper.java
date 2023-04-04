package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Lists;

@Repository
public interface ListsMapper {

	
	// output: int        input : title, url
	public int insertLists (
			@Param("name") String name,
			@Param("url") String url);
	
	
	
	// ouput: List<lists>    input: x
	public List<Lists> selectLists();
	
	
	// 0 
	public boolean existUrl(String url);
	
}
