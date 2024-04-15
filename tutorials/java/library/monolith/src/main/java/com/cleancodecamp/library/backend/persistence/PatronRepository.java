package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.PatronPM;

public interface PatronRepository extends JpaRepository<PatronPM, Long> {
    // You can add custom query methods here if needed
}