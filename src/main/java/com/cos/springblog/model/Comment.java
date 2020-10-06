package com.cos.springblog.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

	private int id;
	private int postId;
	private int userId;
	private String content;
	private Timestamp createDate;
}
