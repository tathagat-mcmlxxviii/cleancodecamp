package com.cleancodecamp.library.backend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleancodecamp.library.backend.persistence.model.PublisherPM;

public interface PublisherRepository extends JpaRepository<PublisherPM, Long> {

}
