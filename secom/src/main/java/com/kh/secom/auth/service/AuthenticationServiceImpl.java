package com.kh.secom.auth.service;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kh.secom.auth.model.vo.CustomUserDetails;
import com.kh.secom.auth.util.JwtUtil;
import com.kh.secom.member.model.vo.MemberDTO;
import com.kh.secom.token.model.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	// private final JwtUtil jwt;

	@Override
	public Map<String, String> login(MemberDTO requestMember) {

		// 사용자 인증
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(requestMember.getUserId(), requestMember.getUserPwd()));
		// UsernamePasswordAuthenticationToken
		/*
		 * 사용자가 입력한 username과 password를 검증하는 용도로 사용하는 클래스 주로, SpringSecurity에서 인증을 시도할 때
		 * 사용함
		 * 
		 *  
		 */

		CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

		log.info("로그인 절차 성공!");
		log.info("DB에서 조회된 사용자의 정보 : {}", user);
		/*
		 * String accessToken = jwt.getAccessToken(user.getUsername()); String
		 * refreshToken = jwt.getRefreshToken(user.getUsername());
		 * log.info("엑세스토큰 발급!! : {}", accessToken); log.info("리프레시 토큰 : {}",
		 * refreshToken);
		 */

		Map<String, String> tokens = tokenService.generateToken(user.getUsername(), user.getUserNo());
		
		
		return tokens;

	}
	
	@Override
	public CustomUserDetails getAuthenticatedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		return user;
	}

	@Override
	public void validWriter(String writer, String username) {
		if (writer != null && !writer.equals(username)) {
			throw new RuntimeException("요청한 사용자와 작성자가 일치하지 않습니다.");
		}
	}

}
