package com.kh.secom.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Getter
public class Member {

	private Long userNo;
	private String userId;
	private String userPwd;
	private String role;
	
}
