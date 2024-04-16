package com.cleancodecamp.library.backend.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cleancodecamp.library.backend.persistence.model.PatronPM;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PatronRepositoryTest {

    @Autowired
    private PatronRepository patronRepository;

    @Test
    public void testSavePatron() {
        // Given
        PatronPM patron = new PatronPM(null, "John Doe", "john@example.com", "123456789", "xyz1");

        // When
        PatronPM savedPatron = patronRepository.save(patron);

        // Then
        assertNotNull(savedPatron.getId(), "ID should be generated");
        PatronPM retrievedPatron = patronRepository.findById(savedPatron.getId()).orElse(null);
        assertNotNull(retrievedPatron, "Patron should be retrieved from the database");
        assertEquals("John Doe", retrievedPatron.getName());
        assertEquals("john@example.com", retrievedPatron.getEmail());
        assertEquals("123456789", retrievedPatron.getPhoneNumber());
    }

    @Test
    public void testFindAllPatrons() {
        // Given
        patronRepository.save(new PatronPM(null, "John Doe", "john@example.com", "123456789", "xyz1"));
        patronRepository.save(new PatronPM(null, "Jane Doe", "jane@example.com", "987654321", "xyz2"));

        // When
        List<PatronPM> patrons = patronRepository.findAll();

        // Then
        assertEquals(2, patrons.size());
    }
}
