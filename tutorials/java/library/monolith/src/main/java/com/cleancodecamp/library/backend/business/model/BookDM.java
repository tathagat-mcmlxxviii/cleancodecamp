package com.cleancodecamp.library.backend.business.model;

import com.cleancodecamp.library.backend.persistence.model.BookPM;

import lombok.Data;
import lombok.NonNull;

@Data
public class BookDM {
	@NonNull
	private Long id;
    
    @NonNull
    private String title;
    
    @NonNull
    private String isin;
    
    @NonNull
    private String authorName;
    
    @NonNull
    private String genreName;
    
    @NonNull
    private String publisherName;
    
    public static BookDM mapPmToDm(BookPM bookPm) {
    	return new BookDM(
				bookPm.getId(), 
				bookPm.getTitle(), 
				bookPm.getIsin(), 
				bookPm.getAuthor().getName(), 
				bookPm.getGenre().getName(), 
				bookPm.getPublisher().getName());
    }
}
