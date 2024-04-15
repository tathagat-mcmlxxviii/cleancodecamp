package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.LoanPM;

public interface LoanRepository extends JpaRepository<LoanPM, Long> {
    // You can add custom query methods here if needed
}
