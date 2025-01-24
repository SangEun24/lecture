package com.kh.secom.auth.service;

import java.util.Map;

import com.kh.secom.member.model.vo.MemberDTO;

public interface AuthenticationService {

	Map<String, String> login(MemberDTO requestMember);
	
}
