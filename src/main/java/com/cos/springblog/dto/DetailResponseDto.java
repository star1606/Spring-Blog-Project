package com.cos.springblog.dto;

import java.util.List;

import com.cos.springblog.model.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailResponseDto {

	
	private BoardResponseDto boardDto;
	
	// reply는 List로 넣어야함
	List<ReplyResponseDto> replyDtos;
}
