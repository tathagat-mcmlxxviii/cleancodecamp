package com.cleancodecamp.library.backend.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.BookPM;

public interface BookRepository extends JpaRepository<BookPM, Long> {

	List<BookPM> findByTitleContainingIgnoreCase(String bookName);

	List<BookPM> findByIsinContainingIgnoreCase(String isbn);

	List<BookPM> findByAuthorNameContainingIgnoreCase(String authorName);

	List<BookPM> findByPublisherNameContainingIgnoreCase(String publisherName);

	List<BookPM> findByGenreNameContainingIgnoreCase(String genreName);
}

