package com.cleancodecamp.library.backend.business.service;

import com.cleancodecamp.library.backend.business.model.PatronDM;
import com.cleancodecamp.library.backend.persistence.PatronRepository;
import com.cleancodecamp.library.backend.persistence.model.PatronPM;

public class PatronManagementServiceImpl implements PatronManagementService {
	
	private PatronRepository patronRepository;

	public PatronManagementServiceImpl(PatronRepository patronRepository) {
		super();
		this.patronRepository = patronRepository;
	}

	@Override
	public void addPatron(String name, String email, String phoneNumber) {
		PatronPM patronPM = new PatronPM(null, name, email, phoneNumber);
		patronRepository.save(patronPM);
	}

	@Override
	public void issueLibraryCard(PatronDM patron) {
		// TODO Auto-generated method stub

	}

}
