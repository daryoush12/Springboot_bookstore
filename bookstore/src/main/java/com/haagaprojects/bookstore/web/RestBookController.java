package com.haagaprojects.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.haagaprojects.bookstore.domain.Book;
import com.haagaprojects.bookstore.domain.BookRepository;

@RestController
public class RestBookController {
	@Autowired
	private BookRepository Brepository;
	
	// RESTful service to get all students
    @RequestMapping(value="/api/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> BookListRest() {	
        return (List<Book>) Brepository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/api/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBooktRest(@PathVariable("id") Long Bookid) {;
    	System.out.println(Bookid);
    	return(Book) Brepository.findOne(Bookid);
    } 
}
