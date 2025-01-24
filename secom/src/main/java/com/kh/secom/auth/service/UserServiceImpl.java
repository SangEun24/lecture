package com.kh.secom.auth.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.secom.auth.model.vo.CustomUserDetails;
import com.kh.secom.member.model.mapper.MemberMapper;
import com.kh.secom.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
	// AuthenticationManager가 실질적으로 사용자의 정보를 조회하는데 사용할 클래스

	private final MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member user = mapper.findByUserId(username);

		if (user == null) {
			throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");
		}
		// 사용자가 입력한 아이디값이 테이블에 존재하긴 함

		return CustomUserDetails.builder().userNo(user.getUserNo()).username(user.getUserId())
				.password(user.getUserPwd())
				.authorities(Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))).build();
	}

}
