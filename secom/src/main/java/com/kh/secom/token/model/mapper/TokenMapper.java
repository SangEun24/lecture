package com.kh.secom.token.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.kh.secom.token.model.dto.RefreshTokenDTO;

@Mapper	
public interface TokenMapper {

	@Insert("INSERT INTO TB_REFRESH_TOKEN VALUES(#{userNo}, #{token}, #{expiration})")	
	void saveToken(RefreshTokenDTO refreshToken);
}
