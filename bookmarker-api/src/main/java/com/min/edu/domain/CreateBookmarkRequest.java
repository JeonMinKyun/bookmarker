package com.min.edu.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

// 입력을 위해서 요청을 처리해주는 객체 + 유효값

@Getter
@Setter
public class CreateBookmarkRequest {

	@NotEmpty(message = "제목은 필수 입력 값입니다")
	private String title;
	@NotEmpty(message = "URL은 필수 입력 값입니다")
	private String url;
}
