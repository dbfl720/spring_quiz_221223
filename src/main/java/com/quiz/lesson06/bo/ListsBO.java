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
	// output: void        input : title, url
	public void addLists(
			String name, String url) {
		
		listsMapper.insertLists(name, url);
	}
	
	
	
	// select
	// ouput: List<lists>    input: x
	public List<Lists> getLists() {
		return listsMapper.selectLists();
	}
	
}
