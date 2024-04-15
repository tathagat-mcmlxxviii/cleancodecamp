package com.cleancodecamp.library.backend.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cleancodecamp.library.backend.persistence.model.AuthorPM;
import com.cleancodecamp.library.backend.persistence.model.BookPM;
import com.cleancodecamp.library.backend.persistence.model.GenrePM;
import com.cleancodecamp.library.backend.persistence.model.PublisherPM;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void testSaveBook() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));
        
        BookPM book = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);

        // When
        BookPM savedBook = bookRepository.save(book);

        // Then
        assertNotNull(savedBook.getId(), "ID should be generated");
        BookPM retrievedBook = bookRepository.findById(savedBook.getId()).orElse(null);
        assertNotNull(retrievedBook, "Book should be retrieved from the database");
        assertEquals("The Great Gatsby", retrievedBook.getTitle());
        assertEquals("F. Scott Fitzgerald", retrievedBook.getAuthor().getName());
        assertEquals("Fiction", retrievedBook.getGenre().getName());
        assertEquals("Penguin Books", retrievedBook.getPublisher().getName());
        assertEquals("9780141182636", retrievedBook.getIsin());
    }

    @Test
    public void testFindAllBooks() {
        // Given
    	int initialSize = bookRepository.findAll().size();
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));
        
        bookRepository.save(new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher));
        bookRepository.save(new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre, publisher));

        // When
        List<BookPM> books = bookRepository.findAll();

        // Then
        assertEquals(initialSize+2, books.size());
    }
    
    @Test
    public void testFindByTitleContainingIgnoreCase() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book1 = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);
        BookPM book2 = new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre, publisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<BookPM> result = bookRepository.findByTitleContainingIgnoreCase("great");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(book1));
    }

    @Test
    public void testFindByIsinContainingIgnoreCase() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book1 = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);
        BookPM book2 = new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre, publisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<BookPM> result = bookRepository.findByIsinContainingIgnoreCase("978014");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(book1));
    }

    @Test
    public void testFindByAuthorNameContainingIgnoreCase() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book1 = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);
        BookPM book2 = new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre, publisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<BookPM> result = bookRepository.findByAuthorNameContainingIgnoreCase("Fitzgerald");

        // Then
        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
    }

    @Test
    public void testFindByPublisherNameContainingIgnoreCase() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher1 = publisherRepository.save(new PublisherPM(null, "Penguin Books"));
        PublisherPM publisher2 = publisherRepository.save(new PublisherPM(null, "Harper Perennial"));

        BookPM book1 = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher1);
        BookPM book2 = new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre, publisher2);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<BookPM> result = bookRepository.findByPublisherNameContainingIgnoreCase("Penguin");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(book1));
    }

    @Test
    public void testFindByGenreNameContainingIgnoreCase() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre1 = genreRepository.save(new GenrePM(null, "Fiction"));
        GenrePM genre2 = genreRepository.save(new GenrePM(null, "Thriller"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book1 = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre1, publisher);
        BookPM book2 = new BookPM(null, "To Kill a Mockingbird", "9780061120084", author, genre2, publisher);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // When
        List<BookPM> result = bookRepository.findByGenreNameContainingIgnoreCase("Fiction");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(book1));
    }
}
