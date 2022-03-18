package com.lcomputerstudy1.example.service;

import java.util.List;
import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Pagination;

public interface BoardService {
	public List<Board> selectBoardList(Pagination pagination);

	public int boardCount(Pagination pagination);
	
	public Board boardDetail(Board board);
	
	public void insertProcess(Board board);
	
	public Board editBoard(Board board);
	
	public void editProcessBoard(Board board);

	public void boardDelete(Board board);
	
	public void boardViewCount(Board board);

}

