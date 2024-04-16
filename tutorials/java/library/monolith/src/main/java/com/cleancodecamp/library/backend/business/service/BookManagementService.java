package com.cleancodecamp.library.backend.business.service;

import com.cleancodecamp.library.backend.business.model.AuthorDM;
import com.cleancodecamp.library.backend.business.model.GenreDM;
import com.cleancodecamp.library.backend.business.model.PublisherDM;

public interface BookManagementService {
	void addBook(String title, String isin, AuthorDM author, GenreDM genre, PublisherDM publisher);
}
