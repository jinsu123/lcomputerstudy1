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
	public void insertProcess(Board board){
		 boardMapper.insertProcess(board);
		 if(board.getbGroup()==0) {
			 boardMapper.updateGroup(board);
			 System.out.print(board.getbGroup());
		 }
	
			 
	}
	
	@Override
	public Board editBoard(Board board){
		return boardMapper.editBoard(board);
	}	
	
	@Override
	public void editProcessBoard(Board board){
		 boardMapper.editProcessBoard(board);
	}
	
	@Override
	public void boardDelete(Board board){
		boardMapper.boardDelete(board);
	}	

	@Override
	public void boardViewCount(Board board){
		boardMapper.boardViewCount(board);
	}	
}
