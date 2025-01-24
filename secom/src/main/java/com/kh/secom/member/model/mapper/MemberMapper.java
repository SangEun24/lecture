package com.kh.secom.member.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.kh.secom.member.model.vo.Member;

@Mapper
public interface MemberMapper {

	Member findByUserId(String userId);

	@Insert("INSERT INTO TB_MEMBER VALUES(SEQ_MNO.NEXTVAL, #{userId}, #{userPwd}, #{role})")
	void save(Member requestMember);

}
