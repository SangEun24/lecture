package com.kh.secom.comment.model.service;

import java.util.List;

import com.kh.secom.comment.model.dto.Comment;

public interface CommentService {

	void insertComment(Comment comment);
	
	List<Comment> findByBoardNo(Long boardNo);
}
