package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.ReservationPM;

public interface ReservationRepository extends JpaRepository<ReservationPM, Long> {
    // You can add custom query methods here if needed
}
