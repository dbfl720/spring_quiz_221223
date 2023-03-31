package com.quiz.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.model.Store;

@Service // **@Service 
public class StoreBO {

	@Autowired   // spring bean을 들고 오고 싶을 때 씀.
	private StoreMapper storeMapper;  //**Mapper와 연결
	
	
	public List<Store> getStoreList() {  // ** 메소드명은 (get + ____) // select 할때 get으로 이름을 지은다.
		return storeMapper.selectStoreList();  //**Mapper와 연결
	}
	
	
	
}
