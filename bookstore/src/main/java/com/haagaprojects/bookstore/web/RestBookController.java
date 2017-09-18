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
	
	// RESTful service to get all book
    @RequestMapping(value="/api/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> BookListRest() {	
        return (List<Book>) Brepository.findAll();
    }    

	// RESTful book by id
    @RequestMapping(value="/api/books/book/{bookid}", method = RequestMethod.GET)
    public @ResponseBody Book findBooktRest(@PathVariable("bookid") Long bookid) {
    	//System.out.println("id: "+bookid);
    	return(Book) Brepository.findOneByid(bookid);
    } 
}
