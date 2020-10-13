package com.cos.springblog.repository;

import java.util.List;

import com.cos.springblog.dto.BoardResponseDto;
import com.cos.springblog.model.Post;

public interface PostRepository {

	public List<Post> findAll();
	
	public List<Post> findAllDesc();
	
	// BoardResponseDto를 가져오기 위해서 findById를 사용
	public BoardResponseDto findById(int id);
	
	public void save(Post post);
	
	

}
