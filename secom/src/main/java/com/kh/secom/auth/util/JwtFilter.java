package com.kh.secom.auth.util;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kh.secom.auth.service.UserServiceImpl;
import com.kh.secom.exception.AccessTokenExpiredException;
import com.kh.secom.exception.JwtTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil tokenUtil;
	private final UserServiceImpl userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

		log.info("우리의 토큰 필터 출동 : {}", authorization);
		if (authorization == null || !authorization.startsWith("Bearer ")) {
			log.error("authorization이 존재하지 않아요~");
			filterChain.doFilter(request, response);
			return;
		}
		// 토큰만 쏙 뽑아내기
		String token = authorization.split(" ")[1];
		// 1. 이거 내 비밀키로 만든거임?
		// 2. 이거 유효기간 안지남?
		try {

			Claims claims = tokenUtil.parseJwt(token);

			String username = claims.getSubject();
			log.info("토큰 주인 아이디 : {}", username);

			// 사용자 정보 로드
			UserDetails userDetails = userService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());

			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			// 세부설정 사용자의 원격주소, MAC주소, 세션 ID등이 포함될 수 있음

			SecurityContextHolder.getContext().setAuthentication(authentication);

		} catch (ExpiredJwtException e) {
			log.info("AccessToken이 만료되었습니다.");
			//throw new AccessTokenExpiredException("토큰이 만료되었습니다~");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Expired Token");
		} catch (JwtException e) {
			log.info("Token 검증에 실패했습니다.");
			//throw new JwtTokenException("이상욧아~");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("이상요상");
		}
		
		filterChain.doFilter(request, response);
	}
	

}
