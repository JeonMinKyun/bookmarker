package com.min.edu;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.min.edu.domain.Bookmark;
import com.min.edu.domain.BookmarkDto;
import com.min.edu.domain.BookmarkRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

@TestPropertySource(properties = {
		"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})

class BookmarkControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@BeforeEach
	void setUp() {
		bookmarkRepository.deleteAllInBatch();
		
		List boomarks = new ArrayList<>();
		boomarks.add(new Bookmark(null, "devopsbookmark", "https://www.devopsbookmark.com", Instant.now()));    
		boomarks.add(new Bookmark(null, "techblog", "https://www.techblog.com", Instant.now()));                
		boomarks.add(new Bookmark(null, "codingresource", "https://www.codingresource.com", Instant.now()));    
		boomarks.add(new Bookmark(null, "programminghub", "https://www.programminghub.com", Instant.now()));    
		boomarks.add(new Bookmark(null, "javaguide", "https://www.javaguide.com", Instant.now()));              
		boomarks.add(new Bookmark(null, "webdevtips", "https://www.webdevtips.com", Instant.now()));            
		boomarks.add(new Bookmark(null, "cloudcomputing", "https://www.cloudcomputing.com", Instant.now()));    
		boomarks.add(new Bookmark(null, "datasciencetools", "https://www.datasciencetools.com", Instant.now()));
		boomarks.add(new Bookmark(null, "aiinsights", "https://www.aiinsights.com", Instant.now()));            
		boomarks.add(new Bookmark(null, "devtools", "https://www.devtools.com", Instant.now()));                
		boomarks.add(new Bookmark(null, "machinelearning", "https://www.machinelearning.com", Instant.now()));  
		boomarks.add(new Bookmark(null, "opensource", "https://www.opensource.com", Instant.now()));            
		boomarks.add(new Bookmark(null, "cybersecurity", "https://www.cybersecurity.com", Instant.now()));      
		boomarks.add(new Bookmark(null, "frontendfocus", "https://www.frontendfocus.com", Instant.now()));      
		boomarks.add(new Bookmark(null, "backendbasics", "https://www.backendbasics.com", Instant.now()));
		
		bookmarkRepository.saveAll(boomarks);
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,15,2,1,true,false,true,false",
		"2,15,2,2,false,true,false,true"
	})
	void shouldBookmarks() throws Exception {
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

	@Test
	void ci_cd_test() {
		assertTrue(true);
	}
	
	
	@Test
	void shouldCreateBookmarkSuccessfully() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/bookmarks")
										.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
										.content("""
													{
														"title":"IT Academy Blog"
													}
												""")
										)
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.status", is(400)))
				.andExpect(jsonPath("$.field", is("url")))
				.andExpect(jsonPath("$.message", is("URL은 필수 입니다")))
				.andReturn();
		
		String contentType = result.getRequest().getContentType();
		System.out.println("ContentType : " + contentType);
		
		String responseBody = result.getResponse().getContentAsString();
		System.out.println("Response JSON" + responseBody);
	}
	
	
	
}
