package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.User;

public interface UserRepository {

	public List<User> findAll();
}
