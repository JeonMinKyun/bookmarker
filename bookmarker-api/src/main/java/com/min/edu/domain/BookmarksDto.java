package com.min.edu.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

// Bookmark Entity 객체와 Pageable 정보를 가지고 있는 DTO객체

@Getter
@Setter
public class BookmarksDto {

	private List<BookmarkDto> data; // 조회 Bookmark의 데이터 집합
	private long totalElements; // 전체 Bookmark의 갯수
	private int totalPage; // page의 전체 갯수
	private int currentPage;  // 현재 페이지
	
	@JsonProperty(value = "isFirst")
	private boolean isFirst; // 첫번째 페이지 여부
	@JsonProperty(value = "isLast")
	private boolean isLast; // 마지막 페이지 여부
	
	private boolean hasNext;  // 다음 페이지가 있는지 여부
	private boolean hasPrevious;  // 이전 페이지가 있는지 여부
	
	public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
		this.setData(bookmarkPage.getContent());
		this.setTotalElements(bookmarkPage.getTotalElements());
		this.setTotalPage(bookmarkPage.getTotalPages());
		this.setCurrentPage(bookmarkPage.getNumber()+1);
		this.setFirst(bookmarkPage.isFirst());
		this.setLast(bookmarkPage.isLast());
		this.setHasNext(bookmarkPage.hasNext());
		this.setHasPrevious(bookmarkPage.hasPrevious());
	}
}
