package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.ListsBO;

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
	
//	
//	@PostMapping("/add_lists")
//	@ResponseBody
//	public String addLists(
//			@RequestParam("name") String name,
//			@RequestParam("url") String url) {
//		
//		// insert
//		listsBO.addLists(name, url);
//		return "성공";
//	}
//	
//	
//	@GetMapping("/result_view")
//	public String resultView(
//			@RequestParam("name") String name,
//			@RequestParam("url") String url)) {
//		return "lesson06/result";
//	}
}
