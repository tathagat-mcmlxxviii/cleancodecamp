package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.AuthorPM;

public interface AuthorRepository extends JpaRepository<AuthorPM, Long> {

}
