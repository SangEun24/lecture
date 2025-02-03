package com.kh.secom.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.secom.board.model.dto.BoardDTO;

import jakarta.validation.Valid;

public interface BoardService {

	void save(BoardDTO board, MultipartFile file);

	List<BoardDTO> findAll(int page);

	BoardDTO findById(Long boardNo);

	BoardDTO update(BoardDTO board, MultipartFile file);

	void deleteById(Long boardNo);

}
