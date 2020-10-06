package com.cos.springblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.springblog.model.Post;
import com.cos.springblog.model.User;
import com.cos.springblog.repository.PostRepository;
import com.cos.springblog.repository.UserRepository;

@Controller
public class TestController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping({ "/", "" })
	public String test(Model model) {
		List<Post> postList = postRepository.findAll();
		model.addAttribute("posts", postList);
		return "home";
	}

	@GetMapping("/join")
	public String joinPage() {
		return "user/joinForm";
	}

	@PostMapping("/joinProc")
	public String join(User user) {
		System.out.println("join 실행" + user);
		userRepository.save(user);
		return "user/loginForm";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "user/loginForm";
	}

	@PostMapping("/loginProc")
	public String login(User user, HttpSession session) {

		User principal = userRepository.login(user); // 로그인을 하고 나서,
		if (principal == null) {
			System.out.println("principal 없음");
			System.out.println(principal);
			return "home";

		} else {
			session.setAttribute("principal", principal);
			System.out.println("principal 있음");

		}

		return "home";
	}
}
