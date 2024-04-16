package com.cleancodecamp.library.backend.business.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class PatronDM {
	@NonNull
	private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String libraryCardId;
}
