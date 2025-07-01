package com.min.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// github actions를 통해서 CI를 구축했습니다
// CI를 통해서 자동으로  변경이 발생하면 Docker hub에 이미지를 자동으로 배포 합니다


@SpringBootApplication
public class BookmarkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkerApiApplication.class, args);
	}

}
