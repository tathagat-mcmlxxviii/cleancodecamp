package com.cleancodecamp.library.backend.persistence.model;

import java.time.LocalDateTime;

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
@Table(name = "Reservation")
public class ReservationPM {
	
	public ReservationPM(Long id, @NonNull PatronPM patron, @NonNull BookPM book, @NonNull LocalDateTime reservationDate) {
		super();
		this.id = id;
		this.patron = patron;
		this.book = book;
		this.reservationDate = reservationDate;
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
    private LocalDateTime reservationDate;
    
    @Setter
    private boolean fulfilled = false;

    // Constructors, getters, setters, and toString() method
}
