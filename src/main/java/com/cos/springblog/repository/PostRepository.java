package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.Post;
import com.cos.springblog.model.User;

public interface PostRepository {

	public List<Post> findAll();
	

}
