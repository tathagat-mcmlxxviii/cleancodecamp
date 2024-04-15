package com.cleancodecamp.library.frontend.controller.search;

import org.springframework.ui.Model;

public interface SearchController {
	String search(String searchString, Model model);
}
