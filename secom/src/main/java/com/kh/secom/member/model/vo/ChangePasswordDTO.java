package com.kh.secom.member.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChangePasswordDTO {

	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영어/숫자만 사용할 수 있습니다.")
	@Size(min = 4, max = 20, message = "비밀번호는 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="현재 비밀번호를 꼭 입력해주세요")
	private String currentPassword;
	
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영어/숫자만 사용할 수 있습니다.")
	@Size(min = 4, max = 20, message = "비밀번호는 4글자 이상 20글자 이하만 사용할 수 있습니다.")
	@NotBlank(message="새 비밀번호를 꼭 입력해주세요")
	private String newPassword;
}
