package com.cleancodecamp.library.backend.business.service;

import java.util.List;

import com.cleancodecamp.library.backend.business.model.BookDM;

public interface SearchService {
    List<BookDM> search(String searchString);
}
