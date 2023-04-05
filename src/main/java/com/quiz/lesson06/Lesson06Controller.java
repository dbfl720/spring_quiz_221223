package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.ListsBO;
import com.quiz.lesson06.model.Lists;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private ListsBO listsBO;
	
	
	// localhost:8080/lesson06/quiz01/add_lists_view
	@GetMapping("/add_lists_view")
	public String addListsView() {
		return "lesson06/lists";
	}
	
	
	
	// localhost:8080/lesson06/quiz01/add_lists
	// *** AJAX 통신으로 오는 요청 결과는 반드시 String이다. 반드시 return 해야됨.  *** 반드시 @ResponseBody 있어야됨.
	@PostMapping("/add_lists")
	@ResponseBody //  데이터를 돌려주는 어노테이션/ 웹 주소로 요청하면, 웹사이트 View 화면이 아닌 json 같은 데이터를 응답값으로 보내준다.
	public Map<String, Object> addLists(     // ** 앞으로 Map으로 할꺼임.** 
			@RequestParam("name") String name,  // @RequestParam("name")  - name은 파라미터명 //  String name - 서버명과 일치. 
			@RequestParam("url") String url) {
		
		// {"code":1,    "result":"성공"}"   -> String 덩어림. 
		// {"code":500,    "errorMessage":"추가하는데 실패했습니다."}    -> String 덩어림. 
		
		
		// insert DB
		int rowCount = listsBO.addLists(name, url);
		
		 Map<String, Object> result = new HashMap<>();         // ???????? data 연관.. ? 성공 메시지 같아야하나...????
		 if (rowCount > 0) {
			 result.put("code", 1);
			 result.put("result", "성공");
		 } else {
			 result.put("code", 500);
			 result.put("errorMessage", "데이터를 추가하는데 실패했습니다.");
		 }
		 
		 return result;     // JSON String으로 응답이 내려감. 
	}

	
	
	
	// localhost:8080/lesson06/quiz01/result_view
	@GetMapping("/result_view")
	public String resultView(Model model) {
		
		// select  DB
		// list 담기 
		List<Lists> list = listsBO.getLists();
		model.addAttribute("list", list);  // model에 담아야 view에서 쓸 수 있다.
		
		return "lesson06/result";
	}
	
	
	
	// AJAX 요청
	@ResponseBody
	@GetMapping("/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("url") String url) {
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", listsBO.existUrl(url));
		return result;
	}
	
	
	
}
