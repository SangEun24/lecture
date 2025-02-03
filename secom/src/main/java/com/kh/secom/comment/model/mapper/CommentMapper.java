package com.kh.secom.comment.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.kh.secom.comment.model.dto.Comment;

@Mapper
public interface CommentMapper {
	
	void insertComment(Comment comment);
	
	List<Comment> findByBoardNo(Long boardNo);
}
