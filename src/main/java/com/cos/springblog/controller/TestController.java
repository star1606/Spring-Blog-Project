package com.cos.springblog.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springblog.dto.BoardResponseDto;
import com.cos.springblog.dto.DetailResponseDto;
import com.cos.springblog.dto.ReplyResponseDto;
import com.cos.springblog.model.Comment;
import com.cos.springblog.model.Post;
import com.cos.springblog.model.User;
import com.cos.springblog.repository.CommentRepository;
import com.cos.springblog.repository.PostRepository;
import com.cos.springblog.repository.UserRepository;
import com.cos.springblog.util.Script;

@Controller
public class TestController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CommentRepository commentRepository;

	
	// detail

	

	// @PostMapping("/replyProc")
	// public @ResponseBody String writeReply(@ModelAttribute Comment reply,
	// HttpSession session) {

	// 폼태그에 userId 담아서 보내기 때문에 session.getAttribute 안쓰고,
	// 바로 reply.getUserId() 하면 되지 않나?
	// 체크
	// User principal = (User)session.getAttribute("principal");

	// System.out.println(principal);

	// 추측: reply은 단지 그냥 매개변수일뿐 내가 생각한 것은 매개변수에 변수를 넣는
	// 메소드를 실행시키는 경우의 다른 범위를 생각한 것 같다
	// System.out.println("reply출력: " + reply); // 왜 암것도 안가져올까 이유: 폼태그 문제였음
	// System.out.println("detailResponseDto출력: " + detailResponseDto); // 왜 암것도
	// 안가져올까

	// 요청하고 보내는 데이터와 응답하고 보여주는 뷰는 분리되어있다
	// 따라서 reply 데이터 요청한 것을 가져왔고 그 데이터를 빈객체에다가 데이터를 set으로 저장해서
	// 뷰에다가 응답한다.
	// Comment requestReply = Comment.builder()
	// id를 빌더하려면 id 히든으로 보내야 하지 않나
	// -> id 안해도 된다 insert SQL에서 자동으로 저장되기 때문에 만들어서 보낼 필요 없음
	// postId는 어떤식으로 보내주는게 나을까
	// userID는 세션으로 해서 보내고
	// .postId(reply.getPostId())
	// .userId(principal.getId())
	// .content(reply.getContent())
	// -> createDate 안 넣어도됨 SQL에서 now()로 처리해주기 때문
	// .build();

	// int result = commentRepository.save(requestReply);

	// if(result == 1) {
	// Script.back("댓글 쓰기가 완료되었습니다.") 하면 새로고침 안됨 당연하다
	// return Script.href("댓글쓰기 완료되었습니다.", "/detail/" + reply.getPostId());
	// } else {
	// return Script.back("댓글쓰기 실패");
	// }

	// }

	@PostMapping("/replyProc")
	public @ResponseBody String replyWrite(@ModelAttribute Comment reply) {

		Comment replyEntitiy = new Comment();
		replyEntitiy.setUserId(reply.getUserId());
		System.out.println("user아이디는?" + reply.getUserId());
		replyEntitiy.setPostId(reply.getPostId());
		replyEntitiy.setContent(reply.getContent());

		int result = commentRepository.save(replyEntitiy);

		if (result == 1) {
			return "1";
		} else {
			return "0";
		}
	}

}
