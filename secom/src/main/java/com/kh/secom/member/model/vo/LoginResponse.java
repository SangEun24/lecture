package com.kh.secom.member.model.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
public class LoginResponse {

	private String username;
	private Map<String, String> tokens;
}
