package com.lcomputerstudy1.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerstudy1.example.domain.Comment;
import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.mapper.CommentMapper;

@Service
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
	
	
	@Override
	public void insertProcess(Comment comment){
		 
		if(comment.getcGroup()==0) {
			commentMapper.insertProcess(comment);	
		}else {
			comment.setcOrder(comment.getcOrder()+1);
			comment.setcDepth(comment.getcDepth()+1);
			commentMapper.insertProcess(comment);	
		}
		
		 if(comment.getcGroup()==0) {
			 commentMapper.updateGroupComment(comment);
		 }else{
			 commentMapper.updateReComment(comment);
		 }
	
			 
	}
	
	
	@Override
	public void editComment(Comment comment){
		commentMapper.editComment(comment);
	}
	
			 
	@Override
	public void commentDelete(Comment comment){
		commentMapper.commentDelete(comment);
	}
	
	
	
}
