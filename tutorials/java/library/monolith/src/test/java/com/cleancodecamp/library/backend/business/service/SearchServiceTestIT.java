package com.cleancodecamp.library.backend.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.cleancodecamp.library.backend.business.model.BookDM;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SearchServiceTestIT {

    @Autowired
    private SearchService searchService;

    @Test
    @Sql({"/data/data-test.sql"})
    public void testSearchByBookName() {
        // When
        List<BookDM> actualBooks = searchService.search("Book");

        // Then
        assertEquals(2, actualBooks.size());
    }
}
