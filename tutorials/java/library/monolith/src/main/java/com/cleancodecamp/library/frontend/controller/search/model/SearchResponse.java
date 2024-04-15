package com.cleancodecamp.library.frontend.controller.search.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchResponse {
	List<SearchResult> searchResult;
}
