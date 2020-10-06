package com.cos.springblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.springblog.model.Post;
import com.cos.springblog.repository.PostRepository;

@Controller
public class TestController {

	@Autowired
	PostRepository postRepository;
	
	@GetMapping({"/",""})
	public String test(Model model) {
		 List<Post> postList = postRepository.findAll();
		model.addAttribute("posts", postList);
		return "home";
	}
	
	
	
}
