package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.Post;

public interface PostRepository {

	public List<Post> findAll();
}
