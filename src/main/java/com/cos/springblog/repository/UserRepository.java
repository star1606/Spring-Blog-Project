package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.User;

public interface UserRepository {

	// findAll 은 인자가 필요 없음
	
	public User login(User user);
	
	public void save(User user);
}
