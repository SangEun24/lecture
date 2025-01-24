package com.kh.secom.token.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.secom.auth.util.JwtUtil;
import com.kh.secom.token.model.dto.RefreshTokenDTO;
import com.kh.secom.token.model.mapper.TokenMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

	private final JwtUtil tokenUtil;
	private final TokenMapper tokenMapper;

	@Override
	public Map<String, String> generateToken(String username, Long userNo) {
		// 1. 엑세스 토큰 만들기
		// 2. 리프레시 토큰 만들기
		Map<String, String> tokens = createTokens(username);

		// 3. 리프레시 토큰 DB에 저장하기
		saveToken(tokens.get("refreshToken"), userNo);
		
		// 4. 만료기간이 지난 리프레시토큰이 있을수 있으니 지워버리기

		// 5. 사용자가 리프레시 토큰 증명하려 할 때 DB가서 조회해오기

		return tokens;
	}

	private Map<String, String> createTokens(String username) {
		String accessToken = tokenUtil.getAccessToken(username);
		String refreshToken = tokenUtil.getRefreshToken(username);

		Map<String, String> tokens = new HashMap();
		tokens.put("accessToken", accessToken);
		tokens.put("refreshToken", refreshToken);

		return tokens;
	}

	private void saveToken(String refreshToken, Long userNo) {

		RefreshTokenDTO token = RefreshTokenDTO.builder().token(refreshToken).userNo(userNo)
				.expiration(System.currentTimeMillis() + 3600000L * 72).build();
		tokenMapper.saveToken(token);

	}

}
