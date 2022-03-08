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
	public int boardCount() {
		return boardMapper.boardCount();
	}
	
	
}
