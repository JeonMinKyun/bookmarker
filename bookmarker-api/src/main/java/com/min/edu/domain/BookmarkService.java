package com.min.edu.domain;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

	private final BookmarkRepository repository;
	
	private final BookmarkMapper bookmarkMapper;
	
	@Transactional(readOnly = true)
	public BookmarksDto getBookmarks(Integer page){
		int pageNo = page<1 ? 0 : page-1;
		Pageable pageable = 
				PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//		return new BookmarksDto(repository.findAll(pageable));
		
//		Page<BookmarkDto> bookmarkPage = 
//				repository.findAll(pageable).map(bookmark -> bookmarkMapper.toDto(bookmark));
		
		Page<BookmarkDto> bookmarkPage = repository.findByBookmarks(pageable);
		
		return new BookmarksDto(bookmarkPage);
		
	}

	@Transactional(readOnly = true)
	public BookmarksDto searchBookmarks(String query, Integer page) {
		int pageNo = page<0 ? 0 : page-1;
		Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//		Page<BookmarkDto> bookmarkPage = repository.searchBookmark(query, pageable);
		
		Page<BookmarkDto> bookmarkPage = repository.findByTitleContainsIgnoreCase(query, pageable);
		
		return new BookmarksDto(bookmarkPage);
	}

	
	public BookmarkDto createBookmark(@Valid CreateBookmarkRequest request) {
		Bookmark bookmark 
		 		= new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
		Bookmark saveBookmark = repository.save(bookmark);
		return bookmarkMapper.toDto(saveBookmark);
	}
	
}







