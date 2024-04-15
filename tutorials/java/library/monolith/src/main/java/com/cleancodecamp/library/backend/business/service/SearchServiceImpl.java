package com.cleancodecamp.library.backend.business.service;

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
    public List<BookDM> searchByBookName(String bookName) {
        return mapPmToDm(bookRepository.findByTitleContainingIgnoreCase(bookName));
    }

    private List<BookDM> mapPmToDm(List<BookPM> byTitleContainingIgnoreCase) {
		return byTitleContainingIgnoreCase.stream()
				.map(p -> BookDM.mapPmToDm(p))
				.collect(Collectors.toList());
	}

	@Override
    public List<BookDM> searchByISBN(String isbn) {
        return mapPmToDm(bookRepository.findByIsinContainingIgnoreCase(isbn));
    }

    @Override
    public List<BookDM> searchByAuthor(String authorName) {
        return mapPmToDm(bookRepository.findByAuthorNameContainingIgnoreCase(authorName));
    }

    @Override
    public List<BookDM> searchByPublisher(String publisherName) {
        return mapPmToDm(bookRepository.findByPublisherNameContainingIgnoreCase(publisherName));
    }

    @Override
    public List<BookDM> searchByGenre(String genreName) {
        return mapPmToDm(bookRepository.findByGenreNameContainingIgnoreCase(genreName));
    }
}
