package com.cleancodecamp.library.backend.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cleancodecamp.library.backend.persistence.model.AuthorPM;
import com.cleancodecamp.library.backend.persistence.model.BookPM;
import com.cleancodecamp.library.backend.persistence.model.GenrePM;
import com.cleancodecamp.library.backend.persistence.model.PatronPM;
import com.cleancodecamp.library.backend.persistence.model.PublisherPM;
import com.cleancodecamp.library.backend.persistence.model.ReservationPM;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void testSaveReservation() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);
        book = bookRepository.save(book);

        PatronPM patron = patronRepository.save(new PatronPM(null, "John Doe", "john@example.com", "123456789"));
        LocalDateTime reservationDate = LocalDateTime.now();

        ReservationPM reservation = new ReservationPM(null, patron, book, reservationDate);

        // When
        ReservationPM savedReservation = reservationRepository.save(reservation);

        // Then
        assertNotNull(savedReservation.getId(), "ID should be generated");
        ReservationPM retrievedReservation = reservationRepository.findById(savedReservation.getId()).orElse(null);
        assertNotNull(retrievedReservation, "Reservation should be retrieved from the database");
        assertEquals(patron.getId(), retrievedReservation.getPatron().getId());
        assertEquals(book.getId(), retrievedReservation.getBook().getId());
        assertEquals(reservationDate, retrievedReservation.getReservationDate());
    }

    @Test
    public void testFindAllReservations() {
        // Given
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));

        BookPM book = new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher);
        book = bookRepository.save(book);

        PatronPM patron = patronRepository.save(new PatronPM(null, "John Doe", "john@example.com", "123456789"));
        LocalDateTime reservationDate = LocalDateTime.now();

        reservationRepository.save(new ReservationPM(null, patron, book, reservationDate));
        reservationRepository.save(new ReservationPM(null, patron, book, reservationDate));

        // When
        long count = reservationRepository.count();

        // Then
        assertEquals(2, count);
    }
}
