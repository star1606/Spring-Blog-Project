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

	private int id;
	private String title;
	private String content;
	private int userId;
	private Timestamp createDate;
	private String username;
	
	
}
