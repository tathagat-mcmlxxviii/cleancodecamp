package com.cleancodecamp.library.backend.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book")
public class BookPM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String title;
    
    @NonNull
    // unique constraint
    private String isin;
    
    @ManyToOne
    @NonNull
    private AuthorPM author;
    
    @ManyToOne
    @NonNull
    private GenrePM genre;
    
    @ManyToOne
    @NonNull
    private PublisherPM publisher;
    
    // TODO - add number of copies some day
}
