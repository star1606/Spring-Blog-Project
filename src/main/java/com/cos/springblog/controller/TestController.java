package com.cos.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping({"/",""})
	public String test(Model model) {
		 List<Post> postList = postRepository.findAll();
		model.addAttribute("posts", postList);
		return "home";
	}
	
	@GetMapping("/join")
	public String joinPage() {
		return "joinForm";
	}
	
	@PostMapping("/joinProc")
	public @ResponseBody String join(User user) {
		userRepository.save(user);
		return "이상 없음";
	}
	
}
