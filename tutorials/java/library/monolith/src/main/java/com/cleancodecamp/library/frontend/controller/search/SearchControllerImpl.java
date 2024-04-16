package com.cleancodecamp.library.frontend.controller.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleancodecamp.library.backend.business.model.BookDM;
import com.cleancodecamp.library.backend.business.service.SearchService;
import com.cleancodecamp.library.frontend.controller.search.model.SearchResult;

import io.micrometer.common.util.StringUtils;

@Controller
public class SearchControllerImpl implements SearchController {

    private SearchService searchService;

    public SearchControllerImpl(SearchService searchService) {
		super();
		this.searchService = searchService;
	}

	@GetMapping("/search")
	@Override
    public String search(@RequestParam(required = false) String searchString, Model model) {
        List<BookDM> books = new ArrayList<>();

        if (StringUtils.isNotBlank(searchString)) {
            books.addAll(searchService.searchByBookName(searchString));
            books.addAll(searchService.searchByISBN(searchString));
            books.addAll(searchService.searchByAuthor(searchString));
            books.addAll(searchService.searchByPublisher(searchString));
            books.addAll(searchService.searchByGenre(searchString));
        }

        List<SearchResult> searchResults = mapToSearchResults(books);
        List<SearchResult> uniqueSearchResults = getUniqueSearchResults(searchResults);
        
        model.addAttribute("searchResult", uniqueSearchResults);
        
        return "search";
    }

    private List<SearchResult> mapToSearchResults(List<BookDM> books) {
        return books.stream()
                .map(book -> new SearchResult(
                        book.getId(),
                        book.getTitle(),
                        book.getIsin(),
                        book.getAuthorName(),
                        book.getPublisherName(),
                        book.getGenreName()
                ))
                .collect(Collectors.toList());
    }

    private List<SearchResult> getUniqueSearchResults(List<SearchResult> searchResults) {
        return searchResults.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

