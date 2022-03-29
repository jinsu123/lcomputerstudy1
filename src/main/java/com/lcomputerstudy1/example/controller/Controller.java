package com.lcomputerstudy1.example.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.filechooser.FileSystemView;

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
import org.springframework.web.multipart.MultipartFile;

import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Comment;
import com.lcomputerstudy1.example.domain.FileUpload;
import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.domain.Search;
import com.lcomputerstudy1.example.domain.User;
import com.lcomputerstudy1.example.mapper.BoardMapper;
import com.lcomputerstudy1.example.service.BoardService;
import com.lcomputerstudy1.example.service.CommentService;
import com.lcomputerstudy1.example.service.FileUploadService;
import com.lcomputerstudy1.example.service.UserService;
import com.mysql.cj.Session;



@org.springframework.stereotype.Controller
public class Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired CommentService commentservice;
	@Autowired FileUploadService fileuploadservice;
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
	public String boardList(Model model, Pagination pagination ) {
//		System.out.println("home");

		int boardCount = boardservice.boardCount(pagination);
		pagination.setCount(boardCount);
		pagination.init();
		List<Board> list = boardservice.selectBoardList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		return "/boardList";
	}
	
	@RequestMapping("/board/detail")
	public String boardDetail(Model model, Board board, Pagination pagination) {
		
		boardservice.boardViewCount(board);
		board = boardservice.boardDetail(board);
	
		int commentCount = commentservice.commentCount(pagination);
		pagination.setCount(commentCount);
		pagination.init();
		List<Comment> list = commentservice.selectCommentList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		model.addAttribute("board", board);
		
		return "/boardDetail";
	}
	
	
	@RequestMapping("/board/insert")
	public String boardInsert(Model model, Board board) {
		
		
		model.addAttribute("board", board);
		
		return "/insert";
	}
	

	@RequestMapping("/board/insertProcess")
	public String insertProcess(Model model, Board board , Authentication authentication) {
		
		User user = (User)authentication.getPrincipal();
		board.setUser(user);
		board.setuIdx(user.getuIdx());
		boardservice.insertProcess(board);
		
		
		String rootPath = "C:/Users/l2-evening/Documents/work10/lcomputerstudy1/src/main/resources/static/img";
		
		for (MultipartFile file : board.getFileList()) {
			   String originalName = file.getOriginalFilename();
		       String filePath = rootPath + "/" + originalName;
		       File dest = new File(filePath);
		       
		       try {
				file.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (MultipartFile file1 : board.getFileList()) {
			if(!board.getFileList().isEmpty()) { 
				FileUpload upload = new FileUpload();
				upload.setfName(file1.getOriginalFilename());
				upload.setbId(board.getbId());
				fileuploadservice.fileUpload(upload);
			}
		}
		
		return "/insertProcess";
	}
	
	
	@RequestMapping("/board/edit")
	public String boardedit(Model model, Board board) {
		
		board = boardservice.editBoard(board);
		
		model.addAttribute("board", board);
		return "/edit";
	}

	@RequestMapping("/board/editProcess")
	public String eidtProcess(Model model, Board board) {
		
		
		boardservice.editProcessBoard(board);
		
		return "/editProcess";
	}
	
	@RequestMapping("/board/delete")
	public String boardDelete(Model model, Board board) {
		
		boardservice.boardDelete(board);
		
		return "/delete";
	}
	
	
	@RequestMapping("/comment/list")
	public String commentList(Model model, Pagination pagination ) {

		int commentCount = commentservice.commentCount(pagination);
		pagination.setCount(commentCount);
		pagination.init();
		List<Comment> list = commentservice.selectCommentList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "/aj_list";
	}


	@RequestMapping("/comment/insert")
	public String commentInsert(Model model, Comment comment, Authentication authentication, Pagination pagination ) {

		User user = (User)authentication.getPrincipal();
		comment.setUser(user);
		comment.setuIdx(user.getuIdx());
		commentservice.insertProcess(comment);
		
		int commentCount = commentservice.commentCount(pagination);
		pagination.setCount(commentCount);
		pagination.init();
		List<Comment> list = commentservice.selectCommentList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		
		return "/aj_list";
	}

	
	@RequestMapping("/comment/edit")
	public String commentedit(Model model, Comment comment ,Authentication authentication, Pagination pagination) {
		
		commentservice.editComment(comment);
		
		int commentCount = commentservice.commentCount(pagination);
		pagination.setCount(commentCount);
		pagination.init();
		List<Comment> list = commentservice.selectCommentList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "/aj_list";
	}
	
	
	@RequestMapping("/comment/delete")
	public String commentDelete(Model model, Comment comment,Authentication authentication, Pagination pagination) {
		
		commentservice.commentDelete(comment);
		
		int commentCount = commentservice.commentCount(pagination);
		pagination.setCount(commentCount);
		pagination.init();
		List<Comment> list = commentservice.selectCommentList(pagination);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "/aj_list";
	}
	
	

}
	
	

