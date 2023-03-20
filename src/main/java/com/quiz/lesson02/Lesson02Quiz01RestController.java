package com.quiz.lesson02;

import java.util.List;

//import org.apache.catalina.Store;   // apach꺼라서.. 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.BO.StoreBO;
import com.quiz.lesson02.model.Store;

@RestController
public class Lesson02Quiz01RestController {

	@Autowired //주입받음.
	private StoreBO storeBO;
	
	
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		List<Store> storeList = storeBO.getStoreList();  // bo야 나한테 데이터좀 줘.
		return storeList;  // list => JSON
	}

}
