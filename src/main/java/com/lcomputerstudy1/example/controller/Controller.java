package com.lcomputerstudy1.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.User;
import com.lcomputerstudy1.example.service.BoardService;
import com.lcomputerstudy1.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	
	@RequestMapping("/")
	public String home(Model model) {
//		System.out.println("home");
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list", list);
		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		userservice.createUser(user);
		
		userservice.createAuthorities(user);
		
		
		return "/login";
	}
}
