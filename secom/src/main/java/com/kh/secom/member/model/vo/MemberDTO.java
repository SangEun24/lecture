package com.kh.secom.member.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
	private Long userNo; 

	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디 값은 영어/숫자만 사용할 수 있습니다.")
	@Size(min = 6, max = 15, message = "아이디 값은 6글자 이상 15글자 이하만 사용할 수 있습니다.")
	@NotBlank(message = "아이디 값은 비어있을 수 없습니다.")
	private String userId;

	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영어/숫자만 사용할 수 있습니다.")
	@Size(min = 4, max = 20, message = "비밀번호는 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message = "비밀번호는 비어있을 수 없습니다.")
	private String userPwd;

	private String role;
}
