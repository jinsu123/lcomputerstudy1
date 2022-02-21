package com.lcomputerstudy1.example.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServicelmpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> selectBoardList(){
		return boardmapper.selectBoardList();
	}
}
