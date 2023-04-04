package com.quiz.lesson06;

import java.util.List;

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
	public String addLists(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// insert DB
		listsBO.addLists(name, url);
		return "성공";
	}

	
	
	
	// localhost:8080/lesson06/quiz01/result_view
	@GetMapping("/result_view")
	public String resultView(Model model) {
		
		// select  DB
		// list 담기 
		List<Lists> list = listsBO.getLists();
		model.addAttribute("list", list);
		
		return "lesson06/result";
	}
}
