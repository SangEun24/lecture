package com.kh.secom.auth.service;

import java.util.Map;

import com.kh.secom.auth.model.vo.CustomUserDetails;
import com.kh.secom.member.model.vo.MemberDTO;

public interface AuthenticationService {

	Map<String, String> login(MemberDTO requestMember);
	
	CustomUserDetails getAuthenticatedUser();
	
	void validWriter(String writer, String username);
}
