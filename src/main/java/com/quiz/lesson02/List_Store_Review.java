package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.BO.ReviewBO;
import com.quiz.lesson02.model.new_review;

@RequestMapping("/lesson02")
@Controller  // view 연결  //요청이 들어오는 스프링 빈
public class List_Store_Review {

		@Autowired
		private ReviewBO reviewBO;
		
		
		// localhost:8080/lesson02/store_review_view
		@GetMapping("/store_review_view")
		public String store_review_view(Model model) {
			
			// DB select
			// list에 담기 - breakpoint 걸기 위해
			List<new_review> reviewList = reviewBO.getReviewList();
			model.addAttribute("reviewList", reviewList);
			return "/lesson02/listStore_review_layout";
		}
}
