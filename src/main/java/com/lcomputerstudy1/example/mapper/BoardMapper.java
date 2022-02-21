package com.lcomputerstudy1.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lcomputerstudy1.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
}
