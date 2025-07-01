package com.min.edu;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.min.edu.domain.Bookmark;
import com.min.edu.domain.BookmarkRepository;

// Test를 위해서 무작위 포트의 사용을 위한 선언
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

// MVC 테스트를 위한 자동 설정
@AutoConfigureMockMvc

//jdbc:tc:postgresql:9.6.8:///databasename
@TestPropertySource(properties = {
		"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})

class BookmarkContollerTest {


	// Test를 위한 MockMvc 객체 DI
	@Autowired
	private MockMvc mvc;
	
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@BeforeEach
	void setUp() {
		bookmarkRepository.deleteAllInBatch();
		
		List<Bookmark> bookmarkList = new ArrayList<>();

        bookmarkList.add(new Bookmark(null, "ChatGPT", "https://chat.openai.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Google", "https://www.google.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Stack Overflow", "https://stackoverflow.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "GitHub", "https://github.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Reddit Programming", "https://www.reddit.com/r/programming", Instant.now()));
        bookmarkList.add(new Bookmark(null, "MDN Web Docs", "https://developer.mozilla.org", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Spring Docs", "https://docs.spring.io", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "YouTube", "https://www.youtube.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Hacker News", "https://news.ycombinator.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Amazon", "https://www.amazon.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Wikipedia", "https://www.wikipedia.org", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Kakao", "https://www.kakao.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Naver", "https://www.naver.com", Instant.now()));
        bookmarkList.add(new Bookmark(null, "Velog", "https://velog.io", Instant.now()));
        
        bookmarkRepository.saveAll(bookmarkList);
	}
	
	

//	@Test
	void shouldBookmarks() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks")).andExpect(status().isOk());
		
		mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks"))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(15)))
		       .andExpect(jsonPath("$.totalPage", CoreMatchers.equalTo(2)))
		       .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)))
		       .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(true)))
		       .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(false)))
		       .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(true)))
		       .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(false)));
		       
	}
	
	// H2가 아닌 Postgresql를 사용하는 테스트를 진행한다
	// flyway migration을 통해서 postgresql에도 create table과 insert가 migration되었다
	// 15개의 셈플데이터를 통해서 1페이지 요청, 2페이지 요청의 결과를 CsvSource를 입력하여 결과를 JUnite 할 수 있따
	@ParameterizedTest
	@CsvSource({
		"1,15,2,1,true,false,true,false",
		"2,15,2,2,false,true,false,true"
	})
	void shouldBookmarks_param(int pageNo, 
											     int totalElements,
											     int totalPage,
											     int currentPage,
											     boolean isFirst,
											     boolean isLast,
											     boolean hasNext,
											     boolean hasPrevious) throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+pageNo))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
		       .andExpect(jsonPath("$.totalPage", CoreMatchers.equalTo(totalPage)))
		       .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
		       .andExpect(jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
		       .andExpect(jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
		       .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
		       .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
		       
	}
	
	
	
	

}














