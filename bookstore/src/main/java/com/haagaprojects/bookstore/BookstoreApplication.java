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
			User user1 = new User("user","$2a$04$5I5PlB8atlxa19Nx0Xng2.jkQAbO4tVrJc1pn6rdh7UR2wgzETawC","USER");
			User user2 = new User("admin","$2a$04$5I5PlB8atlxa19Nx0Xng2.jkQAbO4tVrJc1pn6rdh7UR2wgzETawC","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			};
	}
}
