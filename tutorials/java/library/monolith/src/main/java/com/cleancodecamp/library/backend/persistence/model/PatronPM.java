package com.cleancodecamp.library.backend.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Patron")
public class PatronPM {
    public PatronPM(Long id, @NonNull String name, @NonNull String email, @NonNull String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @Setter
    private String libraryCardId; // alphanumeric. unique.
}