package com.kh.secom.member.model.service;

import java.util.Map;

import com.kh.secom.member.model.vo.ChangePasswordDTO;
import com.kh.secom.member.model.vo.MemberDTO;


public interface MemberService {

	void save(MemberDTO requestMember);

	void changePassword(ChangePasswordDTO changeEntity);

	void deleteByPassword(Map<String, String> password);

	
	
}
