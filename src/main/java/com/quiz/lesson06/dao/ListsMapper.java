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
	
	
	
	// output: boolean       input: url
	// 0: 거짓(중복x)   그 외 : 참 (중복)
	public boolean existUrl(String url);
	
	
	
	
	// output: x       input: id
	public void deleteListsById(int id);
	
}
