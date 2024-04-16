package com.cleancodecamp.library.backend.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleancodecamp.library.backend.business.model.BookDM;
import com.cleancodecamp.library.backend.persistence.BookRepository;
import com.cleancodecamp.library.backend.persistence.model.BookPM;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDM> search(String searchString) {
    	List<BookDM> books = new ArrayList<>();
    	
    	books.addAll(mapPmToDm(bookRepository.findByTitleContainingIgnoreCase(searchString)));
    	books.addAll(mapPmToDm(bookRepository.findByIsinContainingIgnoreCase(searchString)));
    	books.addAll(mapPmToDm(bookRepository.findByAuthorNameContainingIgnoreCase(searchString)));
    	books.addAll(mapPmToDm(bookRepository.findByPublisherNameContainingIgnoreCase(searchString)));
    	books.addAll(mapPmToDm(bookRepository.findByGenreNameContainingIgnoreCase(searchString)));
    	
        return getUniqueSearchResults(books);
    }

    private List<BookDM> mapPmToDm(List<BookPM> byTitleContainingIgnoreCase) {
		return byTitleContainingIgnoreCase.stream()
				.map(p -> BookDM.mapPmToDm(p))
				.collect(Collectors.toList());
	}
    
    private List<BookDM> getUniqueSearchResults(List<BookDM> searchResults) {
        return searchResults.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
