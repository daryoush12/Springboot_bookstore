package com.haagaprojects.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haagaprojects.bookstore.domain.Book;
import com.haagaprojects.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository Brepository;
	
	@RequestMapping(value="/book",method=RequestMethod.GET)
	public String IndexBookStore(Model model) {
		model.addAttribute("books", Brepository.findAll());
		return "book";
	}
	@RequestMapping(value="/add")
	public String addBook(Model model){
		model.addAttribute("book",new Book());
		return "add";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(Book book){
		Brepository.save(book);
		return "redirect:book";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id,Model model){
		System.out.println("DELETE ACTION CALLED: BOOKID:"+id);
		Brepository.delete(id);
		return "redirect:book";
		
	}
	
}
