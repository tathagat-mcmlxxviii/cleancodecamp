package com.cleancodecamp.library.backend.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleancodecamp.library.backend.business.model.BookDM;
import com.cleancodecamp.library.backend.persistence.BookRepository;
import com.cleancodecamp.library.backend.persistence.model.AuthorPM;
import com.cleancodecamp.library.backend.persistence.model.BookPM;
import com.cleancodecamp.library.backend.persistence.model.GenrePM;
import com.cleancodecamp.library.backend.persistence.model.PublisherPM;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private SearchServiceImpl searchService;

    @Test
    public void testSearchByBookName() {
        // Given
        BookPM book1 = new BookPM(1L, "Book 1", "ISBN-1", new AuthorPM(1L, "Author 1"), new GenrePM(1L, "Genre 1"), new PublisherPM(1L, "Publisher 1"));
        BookPM book2 = new BookPM(2L, "Book 2", "ISBN-2", new AuthorPM(2L, "Author 2"), new GenrePM(2L, "Genre 2"), new PublisherPM(2L, "Publisher 2"));
        List<BookPM> repositoryAnswer = Arrays.asList(book1, book2);
        List<BookDM> expectedBooks = Arrays.asList(BookDM.mapPmToDm(book1), BookDM.mapPmToDm(book2));

        // When
        when(bookRepository.findByTitleContainingIgnoreCase(anyString())).thenReturn(repositoryAnswer);
        List<BookDM> actualBooks = searchService.search("Book");

        // Then
        assertEquals(expectedBooks, actualBooks);
    }

    // Similar tests for other search methods like searchByISBN, searchByAuthor, searchByPublisher, searchByGenre
}
