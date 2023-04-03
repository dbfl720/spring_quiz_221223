package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.BO.ReviewBO;
import com.quiz.lesson02.BO.StoreBO;
import com.quiz.lesson02.model.Store;
import com.quiz.lesson02.model.new_review;

@RequestMapping("/lesson02")
@Controller  // view 연결  //요청이 들어오는 스프링 빈
public class List_Store_Review {

		@Autowired   //@Autowired 한 페이지에 두개 써서 작성 가능...!!!!!!!
		private ReviewBO reviewBO;
		
	
		
		// localhost:8080/lesson02/store_review_view?storeId=2&storeName=BHC
		@GetMapping("/store_review_view")
		public String store_review_view(
				@RequestParam(value="storeId") int storeId,
				@RequestParam(value="storeName") String storeName,
				Model model) {
			
			// DB select
			// list에 담기 - breakpoint 걸기 위해
			List<new_review> reviewList = reviewBO.getReviewList(storeId);
			model.addAttribute("reviewList", reviewList);
			model.addAttribute("storeName", storeName);  // model 이런식으로 두개 담을 수 있음!!!!!!!!!!!!!
	
		
			return "/lesson02/listStore_review_layout";
		}
}
