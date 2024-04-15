package com.cleancodecamp.library.backend.persistence.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Loan")
public class LoanPM {
	
    public LoanPM(Long id, @NonNull PatronPM patron, @NonNull BookPM book, @NonNull LocalDate loanDate,
			@NonNull LocalDate dueDate) {
		super();
		this.id = id;
		this.patron = patron;
		this.book = book;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NonNull
    private PatronPM patron;

    @ManyToOne
    @NonNull
    private BookPM book;

    @NonNull
    private LocalDate loanDate;
    @NonNull
    private LocalDate dueDate;
    
    @Setter
    @NonNull
    private LocalDate returnedDate = null;

    // Constructors, getters, setters, and toString() method
}
