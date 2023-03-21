package com.quiz.lesson02;

import java.util.List;

//import org.apache.catalina.Store;   // apach꺼라서.. 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.BO.StoreBO;
import com.quiz.lesson02.model.Store;

@RestController // **View 연결
public class Lesson02Quiz01RestController {

	@Autowired  // 해당하는 Spring Bean을 찾아 사용할 수 있도록 한다.
	private StoreBO storeBO; // **BO와 연결
	
	
	@RequestMapping("/lesson02/quiz01")  //**View 연결 // url path 매핑
	public List<Store> quiz01() {
		List<Store> storeList = storeBO.getStoreList();  //**BO와 연결. //  DB에서 가져오는 거기 때문에
		return storeList;  // list => JSON
	}

}
