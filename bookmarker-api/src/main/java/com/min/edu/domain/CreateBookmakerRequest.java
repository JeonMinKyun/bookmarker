package com.min.edu.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookmakerRequest {

	@NotEmpty(message = "제목은 필수 입니다")
	private String title;
	@NotEmpty(message = "URL은 필수 입니다")
	private String url;
	
}
