package com.application.serviceInterface;

import com.application.model.Library;
import java.util.List;
import java.util.Optional;

public interface LibraryService 
{
	public Library addBook(Library library);
	
	public Library updateBook(Library library, String bookId);
	
	public String deletBook(String bookId);
	
	public List<Library> getAllBooks();
	
	public List<Library> getBookByGenre(String genere);	
	
	public List<Library> getBookByBookName(String bookName);
	
	public Optional<Library> getBookById(String bookId);
}