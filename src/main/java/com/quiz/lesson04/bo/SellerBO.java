package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerMapper;
import com.quiz.lesson04.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;

	// input:닉네임, url, 온도     output: void
	public void addSellerAsField(String nickname, String profileImageUrl, Double temperature) {
		
		sellerMapper.insertSellerAsField(nickname,profileImageUrl,temperature);
	
	}
	
	
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	
	public Seller getSellerById(int id) {  // bo는 꼭 id가 있어야 되서 int로 한다.
		return sellerMapper.selectSellerById(id);
	}
}
