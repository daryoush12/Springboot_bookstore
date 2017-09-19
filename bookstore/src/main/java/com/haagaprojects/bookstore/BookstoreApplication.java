package com.haagaprojects.bookstore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagaprojects.bookstore.domain.User;
import com.haagaprojects.bookstore.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class BookstoreApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner UserToAdded(UserRepository urepository) {
		return (args) -> {
			log.info("DATABASE ACTION: Adding test users:");
			User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5","USER");
			User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			};
	}
}
