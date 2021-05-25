package com.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookdetails", catalog = "library")
public class Library 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private int id;
	private String bookId;
	private int quantity;
	private String bookName;
	private String genre;
	
	public Library() 
	{
		super();
	}
	
	public Library(String bookId, int quantity, String bookName, String genre)
	{
		super();
		this.bookId = bookId;
		this.quantity = quantity;
		this.bookName = bookName;
		this.genre = genre;
	}

	public String getBookId() 
	{
		return bookId;
	}

	public void setBookId(String bookId) 
	{
		this.bookId = bookId;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	public String getBookName() 
	{
		return bookName;
	}

	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}

	public String getGenre() 
	{
		return genre;
	}

	public void setGenre(String genre) 
	{
		this.genre = genre;
	}	
}