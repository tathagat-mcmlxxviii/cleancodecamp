package com.cleancodecamp.library.backend.business.service;

import java.util.List;

import com.cleancodecamp.library.backend.business.model.BookDM;

public interface SearchService {
    List<BookDM> searchByBookName(String bookName);
    List<BookDM> searchByISBN(String isbn);
    List<BookDM> searchByAuthor(String authorName);
    List<BookDM> searchByPublisher(String publisherName);
    List<BookDM> searchByGenre(String genreName);
}
