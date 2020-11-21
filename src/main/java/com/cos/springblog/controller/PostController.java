package com.cos.springblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springblog.dto.BoardResponseDto;
import com.cos.springblog.dto.DetailResponseDto;
import com.cos.springblog.dto.ReplyResponseDto;
import com.cos.springblog.model.Post;
import com.cos.springblog.model.User;
import com.cos.springblog.repository.CommentRepository;
import com.cos.springblog.repository.PostRepository;
import com.cos.springblog.util.Script;

@Controller
public class PostController {

	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	
	
	@GetMapping({ "/detail/{id}" })
	public String detailPage(@PathVariable int id, Model model) {
		BoardResponseDto boardDto = postRepository.findById(id);
		System.out.println(boardDto);

		// 여기서 id는 PostId인 것을 참고해야한다.
		// 주호쌤은 findByPostId가 아닌 findAll로 표현했다
		// 댓글 뿌리기
		List<ReplyResponseDto> replyDtos = commentRepository.findByPostId(id);

		// 빌더, 생성자 공부
		DetailResponseDto detailDto = DetailResponseDto.builder().boardDto(boardDto).replyDtos(replyDtos).build();

		model.addAttribute("detailDto", detailDto);

		return "board/detail";
	}

	// writePage
	@GetMapping("/write")
	public String writePage() {

		return "board/write";
	}

	// key : value로 들어올 때
	// 스프링에서 key : value로 오는 값을 받아서 자동으로 객체로 받아줄 수 있다.
	// write : 글쓰기
	@PostMapping("/writeProc")
	public String write(Post post, HttpSession session) {

		User principal = (User) session.getAttribute("principal");

		System.out.println(principal);

		// principal.getId때문에..
		Post requestPost = Post.builder().title(post.getTitle()).content(post.getContent()).userId(principal.getId())
				.build();

		postRepository.save(requestPost);

		return "redirect:/";
	}

	// delete

	@DeleteMapping("/delete")
	public @ResponseBody String delete(int id) {
		int result = postRepository.deleteById(id);

		if (result == 1) {
			return "1";
		} else {
			return "0";
		}

	}

	// update

	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable int id, Model model) {

		// 이렇게 하면 안된다 boardDto에 id가없음
		// Post post = postRepository.findTitleAndContent(id);

		Post post = postRepository.findByIdInUpdate(id);

		model.addAttribute("boardDto", post);
		return "board/update";
	}

	// return을 어떤식으로 하지
	// update를 어떤식으로 해야되면 id로만 하는게 아니다
	@PostMapping("/updateProc")
	public @ResponseBody String updateProc(Post post) {
		System.out.println("updateProc" + post);

		int result = postRepository.update(post);

		if (result == 1) {
			return Script.href("수정에 성공하였습니다", "/");

		} else {
			return Script.back("수정에 실패하였습니다");
		}
		// 빌더는 들어가고 안들어가고 차이가 뭐지? -> 데이터를 조회할 때 그 데이터를 정제할떄???
		// 어떤식으로 Script 활용할지 생각해봐야할 듯

		// update를 ajax로 해서 해보기.

	}
}
