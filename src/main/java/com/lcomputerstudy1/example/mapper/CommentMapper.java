package com.lcomputerstudy1.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy1.example.domain.Comment;
import com.lcomputerstudy1.example.domain.Pagination;

@Mapper
public interface CommentMapper {

	public List<Comment> selectCommentList(Pagination pagination);

	public int commentCount(Pagination pagination);
}
