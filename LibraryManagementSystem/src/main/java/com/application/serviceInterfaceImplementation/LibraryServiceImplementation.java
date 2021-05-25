package com.application.serviceInterfaceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.dao.LibraryRepository;
import com.application.model.Library;
import com.application.serviceInterface.LibraryService;
import java.util.Optional;

@Service
public class LibraryServiceImplementation implements LibraryService
{
	
	@Autowired
	private LibraryRepository libraryRepo;

	@Override
	public Library addBook(Library library) 
	{
		return libraryRepo.save(library);
	}

	@Override
	public Library updateBook(Library library, String bookId) 
	{
		return libraryRepo.save(library);
	}
	
	@Override
	public String deletBook(String bookId) 
	{
		libraryRepo.deleteById(bookId);
		return null;
	}

	@Override
	public List<Library> getAllBooks() 
	{
		return (List<Library>)libraryRepo.findAll();
	}

	@Override
	public Optional<Library> getBookById(String bookId) 
	{
		return libraryRepo.findById(bookId);
	}
	
	@Override
	public List<Library> getBookByGenre(String genre) 
	{
		return libraryRepo.getBookByGenre(genre);
	}
	
	@Override
	public List<Library> getBookByBookName(String bookName) 
	{
		return libraryRepo.getBookByBookName(bookName);
	}

}