package com.min.edu.domain;

import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

	public BookmarkDto toDto(Bookmark bookmark) {
//		BookmarkDto dto = new BookmarkDto();
//		
//		dto.setId(bookmark.getId());
//		dto.setTitle(bookmark.getTitle());
//		dto.setUrl(bookmark.getUrl());
//		dto.setCreatedAt(bookmark.getCreatedAt());
		
		BookmarkDto dto = 
				new BookmarkDto(bookmark.getId(), bookmark.getTitle(), bookmark.getUrl(), bookmark.getCreatedAt());
		
		return dto;
		
	}
	
}
