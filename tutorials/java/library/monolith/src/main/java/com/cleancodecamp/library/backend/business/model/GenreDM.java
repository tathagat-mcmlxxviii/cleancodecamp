package com.cleancodecamp.library.backend.business.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class GenreDM {
	@NonNull
	private Long id;
	@NonNull
	private String name;
}
