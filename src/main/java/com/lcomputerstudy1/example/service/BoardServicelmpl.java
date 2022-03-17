package com.lcomputerstudy1.example.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.mapper.BoardMapper;

@Service
public class BoardServicelmpl implements BoardService{

	@Autowired BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectBoardList(Pagination pagination){
		return boardMapper.selectBoardList(pagination);
	}
	@Override
	public int boardCount(Pagination pagination) {
		return boardMapper.boardCount(pagination);
	}
	
	
	@Override
	public Board boardDetail(Board board){
		return boardMapper.boardDetail(board);
	}
	
	
	@Override
	public Board insertProcess(Board board){
		return boardMapper.insertProcess(board);
	}
	
	@Override
	public Board editBoard(Board board){
		return boardMapper.editBoard(board);
	}	
	
	@Override
	public Board editProcessBoard(Board board){
		return boardMapper.editProcessBoard(board);
	}
	
	@Override
	public Board boardDelete(Board board){
		return boardMapper.boardDelete(board);
	}	

	@Override
	public Board boardViewCount(Board board){
		return boardMapper.boardViewCount(board);
	}	
}
