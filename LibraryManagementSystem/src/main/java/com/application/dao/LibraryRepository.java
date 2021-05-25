package com.application.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.application.model.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, String>{
	
	public Optional<Library> findById(String id);

	public List<Library> getBookByGenre(String genre); 
	
	public List<Library> getBookByBookName(String bookName); 
}