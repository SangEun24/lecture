package com.kh.secom.member.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.secom.auth.service.AuthenticationService;
import com.kh.secom.member.model.service.MemberService;
import com.kh.secom.member.model.vo.ChangePasswordDTO;
import com.kh.secom.member.model.vo.LoginResponse;
import com.kh.secom.member.model.vo.MemberDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "members", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final AuthenticationService authService;

	// 새롭게 데이터를 만들어내는 요청(INSERT) == POST
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody MemberDTO requestMember) {

		// log.info("요청한 상대방의 데이터 : {}", requestMember);

		memberService.save(requestMember);
		return ResponseEntity.ok("회원가입에 성공했습니다.");
	}

	@PostMapping("login")
	public ResponseEntity<?> login(@Valid @RequestBody MemberDTO requestMember) {

		// 로그인 구현
		/*
		 * 로그인에 성공했을 때??? ==> 인증 ==> 이거 원래 개발자가 했음 아이디 / 비밀번호(평문) 아이디 / 비밀번호(암호문)
		 * 
		 */

		Map<String, String> tokens = authService.login(requestMember);
		// AccessToken
		// RefreshToken 반환

		LoginResponse response = LoginResponse.builder().username(requestMember.getUserId()).tokens(tokens).build();

		// log.info("{}", response);

		return ResponseEntity.ok(response);
	}

	// 비밀번호 변경 기능 구현
	// 기존 비밀번호 / 바꾸고 싶은 비밀번호
	@PutMapping
	public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO changeEntity) {
		
		//log.info("{}", changeEntity);
		memberService.changePassword(changeEntity);
		return ResponseEntity.ok("업데이트에 성공했습니다!");
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteByPassword(){
		
		return null;
	}

}
