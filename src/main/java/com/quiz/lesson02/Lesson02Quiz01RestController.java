package com.quiz.lesson02;

import java.util.List;

//import org.apache.catalina.Store;   // apach꺼라서.. 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.BO.ReviewBO;
import com.quiz.lesson02.BO.StoreBO;
import com.quiz.lesson02.model.Store;

@RequestMapping("/lesson02")
@Controller // **JSP View 연동 //  @Controller만 붙은 클래스의 메소드에서 String을 리턴하면 String 경로의 view를 찾는다.
public class Lesson02Quiz01RestController {

	@Autowired  // 해당하는 Spring Bean을 찾아 사용할 수 있도록 한다.
	private StoreBO storeBO; // **BO와 연결
	
	
//	@RequestMapping("/lesson02/quiz01")  //**View 연결 // url path 매핑
//	public List<Store> quiz01() {
//		List<Store> storeList = storeBO.getStoreList();  //**BO와 연결. //  DB에서 가져오는 거기 때문에
//		return storeList;  // list => JSON
//	}
	
	
	
	//localhost:8080/lesson02/store_layout_view
	@GetMapping("/store_layout_view")
	public String store_Veiw(Model model) {
		
		// DB select
		// list에 담기 - breakpoint 걸기 위해
		List<Store> store = storeBO.getStoreList();
		model.addAttribute("store", store);
				return "/lesson02/listStore_layout"; 
	}
	
	

	
	


}
