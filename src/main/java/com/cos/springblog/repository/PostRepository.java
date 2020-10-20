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
	
	// 지워지면 1  안지워지면 0  int로 해서 return 값을 받음
	public int deleteById(int id);
	
	
	// update
	public Post findTitleAndContent(int id);
	public Post findByIdInUpdate(int id);
	//public int updateById(int id);
	public int update(Post post);
	
}
