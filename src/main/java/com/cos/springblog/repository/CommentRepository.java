package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.dto.ReplyResponseDto;
import com.cos.springblog.model.Comment;

public interface CommentRepository {

//	public List<Comment> findAll();
	
	public List<ReplyResponseDto> findByPostId(int postId);
	
	// 맞는지 한 번 보자~
	// 그냥 public int save(); 만 했다가 이상한걸 느꼈음
	//public int save(int postId);
	public int save(Comment reply);
}
