package com.kh.secom.token.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.secom.token.model.dto.RefreshTokenDTO;

import lombok.Delegate;

@Mapper	
public interface TokenMapper {

	@Insert("INSERT INTO TB_REFRESH_TOKEN VALUES(#{userNo}, #{token}, #{expiration})")	
	void saveToken(RefreshTokenDTO refreshToken);
	
	@Select("SELECT USER_NO userNo, TOKEN, EXPIRED_AT expiration FROM TB_REFRESH_TOKEN WHERE TOKEN=#{refreshToken}")
	RefreshTokenDTO findByToken(String refreshToken);
	
	@Delete("DELETE FROM TB_REFRESH_TOKEN WHERE USER_NO = #{userNo} AND EXPIRED_AT < #{currentTime}")
	void deleteExpiredRefreshToken(Map<String, Long> params);
}
