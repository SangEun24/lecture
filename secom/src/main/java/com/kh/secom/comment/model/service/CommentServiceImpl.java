package com.kh.secom.comment.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.secom.auth.model.vo.CustomUserDetails;
import com.kh.secom.auth.service.AuthenticationService;
import com.kh.secom.board.model.service.BoardService;
import com.kh.secom.comment.model.dto.Comment;
import com.kh.secom.comment.model.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentMapper mapper;
	private final BoardService boardService;
	private final AuthenticationService authService;
 	
	@Override
	public void insertComment(Comment comment) {
		
		// 아 이거 게시글이 있는 게시글인가??
		boardService.findById(comment.getRefBoardNo());
		
		// 아 이거 사용자가 요청한 친구랑 토큰에서 뽑힌 Subject랑 똑같은가??
		CustomUserDetails user = authService.getAuthenticatedUser();
		authService.validWriter(comment.getCommentWriter(), user.getUsername());
		
		comment.setCommentWriter(String.valueOf(user.getUserNo()));
		// INSERT~
		mapper.insertComment(comment);

	}

	@Override
	public List<Comment> findByBoardNo(Long boardNo) {
		return mapper.findByBoardNo(boardNo);
	}

}
