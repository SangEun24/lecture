package com.kh.secom.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.secom.comment.model.dto.Comment;
import com.kh.secom.comment.model.service.CommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("comments")
public class CommentController {

	private final CommentService service;
	
	@PostMapping
	public ResponseEntity<String> insertComment(@Valid @RequestBody Comment comment){
		service.insertComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body("댓글 작성에 성공했습니다.");
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<List<Comment>> findByBoardNo(@PathVariable(name="boardNo") Long boardNo) {
		List<Comment> comments = service.findByBoardNo(boardNo);
		return ResponseEntity.ok(comments);
	}
		
	
}
