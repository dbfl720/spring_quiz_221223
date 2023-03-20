package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;

@Repository
public interface StoreMapper {  // mapper는 xml과 명칭이 일치하기 때문에 mapper로 이름 씀.

	public List<Store> selectStoreList(); // database로 오면 select 쿼리문과 똑같이 해야됨.
}
