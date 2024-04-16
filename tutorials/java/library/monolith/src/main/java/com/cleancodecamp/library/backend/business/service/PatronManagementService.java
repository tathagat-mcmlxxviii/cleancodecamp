package com.cleancodecamp.library.backend.business.service;

import com.cleancodecamp.library.backend.business.model.PatronDM;

public interface PatronManagementService {
	void addPatron(String name, String email, String phoneNumber);
	
	void issueLibraryCard(PatronDM patron);
}
