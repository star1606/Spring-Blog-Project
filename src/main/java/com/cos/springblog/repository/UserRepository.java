package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.User;

public interface UserRepository {

	// findAll 은 인자가 필요 없음
	
	// login 함수의 데이터 타입이 User인 이유는 return할 때 User에 관한 내용을 return 하기 때문임.
	
	public User findByUsernameAndPassword(User user);
	public User findByUsername(User user);

	public void save(User user);
}
