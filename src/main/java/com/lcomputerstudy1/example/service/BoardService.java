package com.lcomputerstudy1.example.service;

import java.util.List;
import com.lcomputerstudy1.example.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();

	public List<Board> boardCount();
}
