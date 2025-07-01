package com.min.edu.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.domain.Bookmark;
import com.min.edu.domain.BookmarkService;
import com.min.edu.domain.BookmarksDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

	private final BookmarkService bookmarkService;
	
	@GetMapping
	public BookmarksDto getBookmark(@RequestParam(name="page", defaultValue = "1") Integer page){
		return bookmarkService.getBookmarks(page);
	}
}





