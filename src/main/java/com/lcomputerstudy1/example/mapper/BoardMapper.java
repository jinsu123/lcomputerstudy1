package com.lcomputerstudy1.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Pagination;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList(Pagination pagination);
	
	public int boardCount();

	public Board boardDetail(Board board);
	
	public Board boardInsert(Board board);
	
	public Board insertProcess(Board board);
}
