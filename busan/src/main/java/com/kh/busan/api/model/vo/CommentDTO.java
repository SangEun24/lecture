package com.kh.busan.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
public class CommentDTO {

	private Long foodNo;
	private String writer;
	private String content;
}
