package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.application.model.Library;
import com.application.serviceInterfaceImplementation.LibraryServiceImplementation;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class HomeController 
{
	@Autowired
	private LibraryServiceImplementation libraryServiceImpl;
	
	@PostMapping(value = "/saveBook")
	public ResponseEntity<Library>  addBook(@RequestBody Library library)
	{
		libraryServiceImpl.addBook(library);
		System.out.println("Books Saved Successfully !!!");
		return new ResponseEntity<Library>(library, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBooks")
	public ResponseEntity<List<Library>>  getAllBooks()
	{
		List<Library> books = libraryServiceImpl.getAllBooks();
		for(Library library:books)
		{
			System.out.println("Book ID:"+library.getBookId()+" ");
			System.out.println("Book Name:"+library.getBookName()+" ");
			System.out.println("Book Genre:"+library.getGenre()+" ");
			System.out.println("Book Quantity:"+library.getQuantity()+" ");
			System.out.println("-------------------------------------------");
		}
		return new ResponseEntity<List<Library>>(books, HttpStatus.OK);
	}
	
	@PutMapping(value = "/editBook")
	public ResponseEntity<Library> updateBook(@RequestBody Library library, @RequestParam String bookId)
	{
		library.setBookId(bookId);
		libraryServiceImpl.addBook(library);
		System.out.println("Changes Updated Successfully!!!");
		return new ResponseEntity<Library>(library, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> deletBook(@RequestParam String bookId)
	{
		libraryServiceImpl.deletBook(bookId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/getById")
	public ResponseEntity<Optional<Library>> getBookById(@RequestParam String bookId)
	{
		Optional<Library> books = libraryServiceImpl.getBookById(bookId);
		if(books.isPresent())
		{
			System.out.println("Books Found with the ID "+bookId+" are : ");
			books.stream().forEach(obj -> {
		    	System.out.println("Book ID:"+obj.getBookId()+" ");
				System.out.println("Book Name:"+obj.getBookName()+" ");
				System.out.println("Book Genre:"+obj.getGenre()+" ");
				System.out.println("Book Quantity:"+obj.getQuantity()+" ");
				System.out.println("-------------------------------------------");
		    });
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<Optional<Library>>(books,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByType")
	public ResponseEntity<List<Library>> getBookByType(@RequestParam String id)
	{
		List<Library> books = libraryServiceImpl.getBookByGenre(id);
		if(books.size() != 0)
		{
			System.out.println("Books Found with the name "+id+" are : ");
			for(Library library:books)
			{
		    	System.out.println("Book ID:"+library.getBookId()+" ");
				System.out.println("Book Name:"+library.getBookName()+" ");
				System.out.println("Book Genre:"+library.getGenre()+" ");
				System.out.println("Book Quantity:"+library.getQuantity()+" ");
				System.out.println("-------------------------------------------");
		    }
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<List<Library>>(books,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getByName")
	public ResponseEntity<List<Library>> getBookByName(@RequestParam String id)
	{
		List<Library> books = libraryServiceImpl.getBookByBookName(id);
		if(books.size() != 0)
		{
			System.out.println("Books Found with the name "+id+" are : ");
			for(Library library:books)
			{
		    	System.out.println("Book ID:"+library.getBookId()+" ");
				System.out.println("Book Name:"+library.getBookName()+" ");
				System.out.println("Book Genre:"+library.getGenre()+" ");
				System.out.println("Book Quantity:"+library.getQuantity()+" ");
				System.out.println("-------------------------------------------");
		    }
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<List<Library>>(books,HttpStatus.OK);
	}
}
