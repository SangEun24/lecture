package com.kh.busan.api.model.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
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
public class CommentDTO implements Serializable {

	private Long foodNo;
	@NotBlank(message = "ID는 필수 입력값입니다.")
	private String writer;
	
	private String content;
}
