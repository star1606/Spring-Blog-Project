package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.model.Comment;
import com.cos.springblog.model.Post;

public interface CommentRepository {

	public List<Comment> findAll();
}
