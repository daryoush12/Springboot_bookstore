package com.haagaprojects.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haagaprojects.bookstore.domain.BookRepository;
import com.haagaprojects.bookstore.domain.User;
import com.haagaprojects.bookstore.domain.UserRepository;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
