package com.cos.springblog.dto;

import java.sql.Timestamp;

import com.cos.springblog.model.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {

	//쌤이 했던 방식
	private Post board;
	
	
	// 광열이 형 방식
	// Post의 필드
	private int id;
	private String title;
	private String content;
	private int userId;
	private Timestamp createDate;
	
	// User의 필드
	private String username;
	
	
}
