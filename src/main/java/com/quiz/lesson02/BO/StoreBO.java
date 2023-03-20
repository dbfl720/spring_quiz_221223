package com.quiz.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.model.Store;

@Service
public class StoreBO {

	@Autowired   // new를 하지 않고 스프링 객체 가져오는 방법
	private StoreMapper storeMapper;  // 리스트 요청할려고 storeMapper 온거임. 
	
	
	public List<Store> getStoreList() {  // select 할때 get으로 이름을 지은다.
		return storeMapper.selectStoreList();
	}
}
