package com.cleancodecamp.library.frontend.controller.search.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class SearchResult {
	@NonNull
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String isin;
	@NonNull
	private String author;
	@NonNull
	private String publisher;
	@NonNull
	private String genre;
}
