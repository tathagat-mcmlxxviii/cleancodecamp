package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.GenrePM;

public interface GenreRepository extends JpaRepository<GenrePM, Long> {

}
