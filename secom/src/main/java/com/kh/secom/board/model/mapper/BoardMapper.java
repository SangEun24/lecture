package com.kh.secom.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.secom.board.model.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	void save(BoardDTO board);

	List<BoardDTO> findAll(RowBounds rowBounds);

	BoardDTO findById(Long boardNo);

	void update(BoardDTO exsitingBoard);

	@Delete("DELETE FROM TB_BOARD WHERE BOARD_NO = #{boardNo}")
	void deleteById(Long boardNo);

}
