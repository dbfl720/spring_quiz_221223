package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.ListsMapper;
import com.quiz.lesson06.model.Lists;

@Service
public class ListsBO {

		
	@Autowired
	private ListsMapper listsMapper;
	
	
	// insert
	// output: 성공된 행의 개수       input : name, url
	public int addLists(
			String name, String url) {
		
		return listsMapper.insertLists(name, url);   // mybatis가 성공된 행의 개수 돌려주는 거임.
	}
	
	
	
	// select
	// ouput: List<lists>    input: x
	public List<Lists> getLists() {
		return listsMapper.selectLists();
	}
	
	
	
	// select
	// output: boolean  input:url
	public boolean existUrl(String url) {
		return listsMapper.existUrl(url);
	}
	
}
