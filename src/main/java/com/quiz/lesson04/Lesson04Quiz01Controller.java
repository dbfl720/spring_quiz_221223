package com.quiz.lesson04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;



@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// **1. 처음 확인해야 할 것 - jsp와 연동이 되는지 체크 - return문 작성해서! 
	// localhost:8080/lesson04/quiz01/add_seller_view
	@GetMapping(path="/add_seller_view") // GetMapping으로 하면 Get만 들어올 수 있음.
	public String addSellerView() { // 파라미터 받아올 필요없이 바로 jsp로 가면 됨.
		// /WEB-INF/jsp/lesson04/addSeller.jsp
		return "lesson04/addSeller";
	}
	
	
	
	// 1. 처음 확인해야 할 것 - return문에 브레이크 포인트 걸고, 입력성공 페이지가 넘어오는데 return문 만들어서 확인해야함.
	// form태그 이용하기 때문에 무조건 PostMapping 
	@PostMapping("/add_seller_view") // @PostMapping - 주소창에 파라미터가 노출되지 않는다.
	public String addSeller(
			// jsp -  name과 일치하게 @RequestParam 지정해랏!
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,  // 비필수 - null 허용
			@RequestParam(value="temperature", required=false) Double temperature) {  
		
		
		// 요청 - insert DB
		// 보통은 필드로 많이 보냄. 
		sellerBO.addSellerAsField(nickname,profileImageUrl,temperature);
		
		
		// 응답 - jsp view
		return "/lesson04/afterAddSeller";
	}
			
			
	


	
	
	// 최신 가입자
	// localhost:8080/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String getLatestSellerView(Model model) { // model - 중간 매개체 역할(데이터 바구니) , map이랑 사용법 동일 (key,value)
		// DB SELECT
		Seller seller = sellerBO.getLatestSeller();
		model.addAttribute("seller", seller); // 명칭 아무렇게 써도 됨. 하지만 view화면(jsp)에서 꺼낼때는 이 명칭으로 꺼냄. 
		model.addAttribute("information", "판매자 정보");
		return "lesson04/getLatestSeller"; // view 페이지로 보낸다. jsp명을 getLatestSeller로 쓴다.
		
	}
			
		
	

	// 최신 가입자
		// localhost:8080/lesson04/quiz01/seller_info
		@RequestMapping("/seller_info") 
		public String getLatestSellerViewById(
				@RequestParam(value=("id"), required = false) Integer id, 
				Model model) { // Integer : 기본타입을 객체로 다루기 위해 사용하는 래퍼 클래스.(null값 처리 가능)
							// Model : view에게 데이터를 전달할 때 사용.
			
			if(id != null) {
				Seller seller = sellerBO.getLatestSellerById(id);
				model.addAttribute("seller", seller); // 명칭 아무렇게 써도 됨. 하지만 view화면(jsp)에서 꺼낼때는 이 명칭으로 꺼냄. 
				model.addAttribute("information", "판매자 정보");
			} else {
				Seller seller = sellerBO.getLatestSeller();
				model.addAttribute("seller", seller); // 명칭 아무렇게 써도 됨. 하지만 view화면(jsp)에서 꺼낼때는 이 명칭으로 꺼냄. 
				model.addAttribute("information", "판매자 정보");
			}
		
			return "lesson04/getLatestSeller";

		}
	
	



}
