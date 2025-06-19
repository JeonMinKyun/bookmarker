package com.min.edu.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarksDto {

	private List<BookmarkDto> data;
	private long totalElements;
	private int totalPage;
	private int currentPage;
	@JsonProperty(value = "isFirst")
	private boolean isFirst;
	@JsonProperty(value = "isLast")
	private boolean isLast;
	private boolean hasNext;
	private boolean hasPrevious;
	
	
	public BookmarksDto(Page<BookmarkDto> bookmarksPage) {
		this.setData(bookmarksPage.getContent());
		this.setTotalElements(bookmarksPage.getTotalElements());
		this.setTotalPage(bookmarksPage.getTotalPages());
		this.setCurrentPage(bookmarksPage.getNumber()+1);
		this.setFirst(bookmarksPage.isFirst());
		this.setLast(bookmarksPage.isLast());
		this.setHasNext(bookmarksPage.hasNext());
		this.setHasPrevious(bookmarksPage.hasPrevious());
	}
	
	
	
}
