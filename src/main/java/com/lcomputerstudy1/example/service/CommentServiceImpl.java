package com.lcomputerstudy1.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lcomputerstudy1.example.domain.Comment;
import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.mapper.CommentMapper;

public class CommentServiceImpl implements CommentService{

	@Autowired CommentMapper commentMapper;	

	@Override
	public List<Comment> selectCommentList(Pagination pagination){
		return commentMapper.selectCommentList(pagination);
	}

	@Override
	public int commentCount(Pagination pagination){
		return commentMapper.commentCount(pagination);
	}
	
}
