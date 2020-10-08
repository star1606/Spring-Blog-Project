package com.cos.springblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.cos.springblog.util.Script;

@Controller
public class TestController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	// dashboard
		@GetMapping({ "/", "" })
		public String home(Model model) {
			List<Post> posts = postRepository.findAll();
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
		@GetMapping("/logout") //getMapping으로 해줘야함
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
			User username = userRepository.findByUsername(user);
			if(username != null) {
				return Script.back("아이디가 중복되었습니다.");
				
			} else {
				userRepository.save(user);
				return Script.href("회원가입이 완료되었습니다.", "/login");
			}


			
		}

	}

