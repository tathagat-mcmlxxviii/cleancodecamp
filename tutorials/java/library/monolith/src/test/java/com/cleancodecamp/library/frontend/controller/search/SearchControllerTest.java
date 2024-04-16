package com.cleancodecamp.library.frontend.controller.search;

import static org.hamcrest.collection.IsIterableWithSize.iterableWithSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import com.cleancodecamp.library.backend.business.model.BookDM;
import com.cleancodecamp.library.backend.business.service.SearchService;
import com.cleancodecamp.library.frontend.controller.search.model.SearchResult;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private SearchService searchService;

	@Test
	void shouldNotSearch_NotSearchStringPassed() throws Exception {
		this.mockMvc.perform(get("/search"))
			.andExpect(status().isOk())
			.andExpect(view().name("search"))
			.andExpect(model().attributeExists("searchResult"))
			.andExpect(model().attribute("searchResult", new ArrayList<SearchResult>()));
	}
	
	@Test
	void shouldSearch() throws Exception {
		// given
		BookDM book1 = new BookDM(1L, "Book 1", "ISBN-1", "Author 1", "Genre 1", "Publisher 1");
		BookDM book2 = new BookDM(2L, "Book 2", "ISBN-2", "Author 2", "Genre 2", "Publisher 2");
		when(searchService.search(anyString())).thenReturn(Arrays.asList(book1, book2));
		
		// when
		MvcResult result = this.mockMvc.perform(get("/search?searchString=xyz"))
		// then
//			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isOk())
			.andExpect(view().name("search"))
			.andExpect(model().attributeExists("searchResult"))
			.andExpect(model().attribute("searchResult", iterableWithSize(2)))
			.andReturn();
		
		ModelAndView modelAndView = result.getModelAndView();
		Map<String, Object> model = modelAndView.getModel();
		@SuppressWarnings("unchecked")
		List<SearchResult> searchResult = (List<SearchResult>) model.get("searchResult");
		assertEquals(2, searchResult.size());
		assertTrue(searchResult.stream().anyMatch(sr -> sr.getId().equals(1L)));
		assertTrue(searchResult.stream().anyMatch(sr -> sr.getId().equals(2L)));
	}
}
