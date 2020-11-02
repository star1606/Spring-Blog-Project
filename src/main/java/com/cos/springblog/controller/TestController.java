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

	// dashboard
	@GetMapping({ "/", "" })
	public String home(Model model) {
		List<Post> posts = postRepository.findAllDesc();
		model.addAttribute("posts", posts);
		return "home";
	}

	// login
	// 페이지 이동외에 어떤 작업 후에 return을 viewResolver로 하는 것은 잘못된 방법이다.
	@GetMapping("/login")
	public String loginPage() {

		return "user/loginForm";
	}

	// loginProc로 페이지가 이동하지만 처리하는 이동이고 보여주는 페이지가 아니다.
	@PostMapping("/loginProc")
	public @ResponseBody String loginProc(User user, HttpSession session) {
		User principal = userRepository.findByUsernameAndPassword(user);

		if (principal != null) {
			session.setAttribute("principal", principal);
			return Script.href("로그인이 완료되었습니다.", "/");
		} else {
			// return Script.outText("아이디나 비밀번호가 틀렸습니다."); 이렇게만 하면 login Proc로 이동함
			return Script.href("비밀번호나 아이디가 틀렸습니다.", "/login");
			// 근데 이 부분은 script로 처리하는 것이 아닌 다른 방법으로 확인해줘야 할 것 같다.
		}

	}

	// logout
	@GetMapping("/logout") // getMapping으로 해줘야함
	public @ResponseBody String logout(HttpSession session) {
		session.invalidate();

		return Script.href("로그아웃하였습니다.", "/");
	}

	// join
	@GetMapping("/join")
	public String joinPage() {

		return "user/joinForm";
	}

	@PostMapping("/joinProc")
	public @ResponseBody String joinProc(User user) {
		System.out.println("joinProc 실행" + user);
		User username = userRepository.findByUsername(user.getUsername());
		if (username != null) {
			return Script.back("아이디가 중복되었습니다.");

		} else {
			userRepository.save(user);
			return Script.href("회원가입이 완료되었습니다.", "/login");
		}

	}
	
	

	// detail

	@GetMapping({ "/detail/{id}" })
	public String detailPage(@PathVariable int id, Model model) {
		BoardResponseDto boardDto = postRepository.findById(id);
		System.out.println(boardDto);

		// 여기서 id는 PostId인 것을 참고해야한다.
		// 주호쌤은 findByPostId가 아닌 findAll로 표현했다 
		// 댓글 뿌리기
		List<ReplyResponseDto> replyDtos = commentRepository.findByPostId(id);
		
		
		
		// 빌더, 생성자 공부
		DetailResponseDto detailDto = DetailResponseDto.builder()
				.boardDto(boardDto)
				.replyDtos(replyDtos)
				.build();

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
		
	  User principal = (User)session.getAttribute("principal");
		
	  	System.out.println(principal);
		
	  	
	  	// principal.getId때문에..
		Post requestPost = Post.builder()
				.title(post.getTitle())
				.content(post.getContent())
				.userId(principal.getId())
				.build();
		
		
		postRepository.save(requestPost);
		
		return "redirect:/";
	}
	
	// delete
	
	@DeleteMapping("/delete")
	public @ResponseBody String delete(int id) {
		int result = postRepository.deleteById(id);
		
		if(result == 1) {
			return "1";	
		} else {
			return "0";
		}
		
	}
	
	
	
	// update
	
	@GetMapping("/update/{id}")
	public String updatePage(@PathVariable int id, Model model) {
		
		//이렇게 하면 안된다 boardDto에 id가없음
		//Post post = postRepository.findTitleAndContent(id);
		
		Post post = postRepository.findByIdInUpdate(id);
		
		model.addAttribute("boardDto", post);
		return "board/update";
	}
	
	// return을 어떤식으로 하지
	// update를 어떤식으로 해야되면 id로만 하는게 아니다
	@PostMapping("/updateProc")
	public @ResponseBody String updateProc(Post post){
		System.out.println("updateProc" + post);
		
		int result = postRepository.update(post);
		
		if(result == 1) {
			return Script.href("수정에 성공하였습니다", "/");
		
		} else {
			return Script.back("수정에 실패하였습니다");
		}
		// 빌더는 들어가고 안들어가고 차이가 뭐지? -> 데이터를 조회할 때 그 데이터를 정제할떄???
		// 어떤식으로 Script 활용할지 생각해봐야할 듯
		
		// update를 ajax로 해서 해보기.
		

	}
	
	
	
	@PostMapping("/replyProc") 
	public @ResponseBody String writeReply(Comment reply) {
		
		System.out.println("reply출력: " + reply); // 왜 암것도 안가져올까
		//System.out.println("detailResponseDto출력: " + detailResponseDto); // 왜 암것도 안가져올까
		
		
//		int result = commentRepository.save();
		
		
//		if(result == 1) {
//			return "1";
//		} else {
//			return "0";
//		}
		return "응";
	}
	
	
	
	
}
