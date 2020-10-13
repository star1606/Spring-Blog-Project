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
public class ReplyResponseDto {

	
	// DTO 만드는 법 다시 공부
	
	private int id;
	private int userId;
	private int postId;
	private String content;
	private Timestamp createDate;
	
	//user 부분의 필드
	private String username;
	
	
	
}
