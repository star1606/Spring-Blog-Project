package com.cos.springblog.repository;

import java.util.List;



import com.cos.springblog.dto.BoardResponseDto;
import com.cos.springblog.model.Post;

public interface PostRepository {

	
	// detail 데이터 조회
	public List<Post> findAll();
	
	public List<Post> findAllDesc();
	
	// BoardResponseDto를 가져오기 위해서 findById를 사용
	public BoardResponseDto findById(int id);
	
	
	// 글 저장 int 형으로 바꿔서 만들어도 될듯함 (댓글쓰기는 int형으로 함)
	public void save(Post post);
	
	
	
	// delete
	// 지워지면 1  안지워지면 0  int로 해서 return 값을 받음
	public int deleteById(int id);
	
	
	
	// update
	// update 페이지 select로 가져오기
	public Post findByIdInUpdate(int id);
	
	
	// 메소드를 int id 만 받으면 안된다 실수 
	//public int updateById(int id);
	// 글 수정하기
	public int update(Post post);
	
}
