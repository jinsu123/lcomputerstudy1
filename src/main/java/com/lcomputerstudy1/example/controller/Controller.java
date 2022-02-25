package com.lcomputerstudy1.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.User;
import com.lcomputerstudy1.example.service.BoardService;
import com.lcomputerstudy1.example.service.UserService;


@org.springframework.stereotype.Controller
public class Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired PasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String home(Model model) {
//		System.out.println("home");
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		System.out.println("home1");
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
//		System.out.println("home2");
		userservice.createUser(user);
//		System.out.println("home3");
		userservice.createAuthorities(user);
		
		
		return "/login";
	}
		
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	
	@Secured({"ROLE_ADMIN"})
		@RequestMapping(value="/admin")
		public String admin(Model model) {
			
			return "/admin";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
		
		return "/user_info";
	}
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		
		return "/denied";
	}
	
	@RequestMapping("/board/list")
	public String boardList(Model model) {
//		System.out.println("home");
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		return "/boardList";
	}
	
}
	
	

