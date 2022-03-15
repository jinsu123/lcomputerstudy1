package com.lcomputerstudy1.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.domain.Search;
import com.lcomputerstudy1.example.domain.User;
import com.lcomputerstudy1.example.mapper.BoardMapper;
import com.lcomputerstudy1.example.service.BoardService;
import com.lcomputerstudy1.example.service.UserService;
import com.mysql.cj.Session;


@org.springframework.stereotype.Controller
public class Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired PasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String home(Model model, Pagination pagination) {
//		System.out.println("home");
		List<Board> list = boardservice.selectBoardList(pagination);
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
	public String signup(User user, String username) {
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
	public String boardList(Model model, Pagination pagination) {
//		System.out.println("home");
		
		int boardCount = boardservice.boardCount();
		pagination.setCount(boardCount);
		pagination.init();
		List<Board> list = boardservice.selectBoardList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "/boardList";
	}
	
	@RequestMapping("/board/detail")
	public String boardDetail(Model model, Board board) {
		
		board = boardservice.boardDetail(board);
	
		model.addAttribute("board", board);
		
		return "/boardDetail";
	}
	
	
	@RequestMapping("/board/insert")
	public String boardInsert(Model model) {
		
		return "/insert";
	}
	

	@RequestMapping("/board/insertProcess")
	public String insertProcess(Model model, Board board , Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();
		board.setUser(user);
		board.setuIdx(user.getuIdx());
		board = boardservice.insertProcess(board);
		
		model.addAttribute("board", board);	
		return "/insertProcess";
	}
	
	
	@RequestMapping("/board/edit")
	public String boardedit(Model model) {
		
		return "/edit";
	}
	
}
	
	

