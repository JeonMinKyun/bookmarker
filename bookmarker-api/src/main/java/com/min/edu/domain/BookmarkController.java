package com.min.edu.domain;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

	private final BookmarkService bookmarkService;
	
	@GetMapping
	public BookmarksDto /*List<Bookmark>*/ getBookmark(@RequestParam(name = "page", defaultValue = "1") Integer page,
													   @RequestParam(name ="query", defaultValue = "") String query){
		if(query == null || query.trim().length() == 0) {
			return bookmarkService.getBookmarks(page);
		}
		return bookmarkService.searchBookmarks(query, page);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public BookmarkDto createBookmark(@RequestBody @Valid CreateBookmakerRequest request) {
		return bookmarkService.createBookmark(request);
	}
	
	
}
















