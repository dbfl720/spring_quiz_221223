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
	// output: Lists - 1개행 또는 0개행     input:url
	public  Lists getListsByUrl(String url) {   // 하나의 행을 가져오는 거는 Lists로 ouput 쓴다. 
		return listsMapper.selectListsByUrl(url);
	}
	
	
	
	// delete
	// output: int     input: id
	public int deleteListsById (int id) {
		return listsMapper.deleteListsById(id);
	}
	
}
