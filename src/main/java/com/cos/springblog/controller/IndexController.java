package com.cos.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.springblog.model.Post;
import com.cos.springblog.repository.PostRepository;

@Controller
public class IndexController {
	
	@Autowired
	PostRepository postRepository;
	
	
		// dashboard 메인화면
			@GetMapping({ "/", "" })
			public String home(Model model) {
				List<Post> posts = postRepository.findAllDesc();
				model.addAttribute("posts", posts);
				return "home";
			}

}
