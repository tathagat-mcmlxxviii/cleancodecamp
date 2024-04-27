package com.cleancodecamp.library.backend.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cleancodecamp.library.backend.persistence.model.AuthorPM;
import com.cleancodecamp.library.backend.persistence.model.BookPM;
import com.cleancodecamp.library.backend.persistence.model.GenrePM;
import com.cleancodecamp.library.backend.persistence.model.LoanPM;
import com.cleancodecamp.library.backend.persistence.model.PatronPM;
import com.cleancodecamp.library.backend.persistence.model.PublisherPM;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;

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
    public void testSaveLoan() {
        // Given
        PatronPM patron = patronRepository.save(new PatronPM(null, "John Doe", "john@example.com", "123456789"));
        AuthorPM author = new AuthorPM(null, "F. Scott Fitzgerald");
        GenrePM genre = new GenrePM(null, "Fiction");
        PublisherPM publisher = new PublisherPM(null, "Penguin Books");
        BookPM book = bookRepository.save(new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher));
        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanDate.plusDays(14); // Due date is 14 days from loan date

        LoanPM loan = new LoanPM(null, patron, book, loanDate, dueDate);

        // When
        LoanPM savedLoan = loanRepository.save(loan);

        // Then
        assertNotNull(savedLoan.getId(), "ID should be generated");
        LoanPM retrievedLoan = loanRepository.findById(savedLoan.getId()).orElse(null);
        assertNotNull(retrievedLoan, "Loan should be retrieved from the database");
        assertEquals(patron.getId(), retrievedLoan.getPatron().getId());
        assertEquals(book.getId(), retrievedLoan.getBook().getId());
        assertEquals(loanDate, retrievedLoan.getLoanDate());
        assertEquals(dueDate, retrievedLoan.getDueDate());
    }

    @Test
    public void testFindAllLoans() {
        // Given
        PatronPM patron = patronRepository.save(new PatronPM(null, "John Doe", "john@example.com", "123456789"));
        AuthorPM author = authorRepository.save(new AuthorPM(null, "F. Scott Fitzgerald"));
        GenrePM genre = genreRepository.save(new GenrePM(null, "Fiction"));
        PublisherPM publisher = publisherRepository.save(new PublisherPM(null, "Penguin Books"));
        BookPM book = bookRepository.save(new BookPM(null, "The Great Gatsby", "9780141182636", author, genre, publisher));
        LocalDate loanDate = LocalDate.now();
        LocalDate dueDate = loanDate.plusDays(14); // Due date is 14 days from loan date

        loanRepository.save(new LoanPM(null, patron, book, loanDate, dueDate));
        loanRepository.save(new LoanPM(null, patron, book, loanDate, dueDate));

        // When
        long count = loanRepository.count();

        // Then
        assertEquals(2, count);
    }
}
