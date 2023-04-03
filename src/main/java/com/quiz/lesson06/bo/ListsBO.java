package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.ListsMapper;

@Service
public class ListsBO {

		
	@Autowired
	private ListsMapper listsMapper;
	
	
	// output: list  input : title, url
	public void addLists(
			String name, String url) {
		
		listsMapper.insertLists(name, url);
	}
	
	public 
}
