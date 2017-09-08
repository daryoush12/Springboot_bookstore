package com.haagaprojects.bookstore.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
List<Book>findBytitle(String title);
List<Book>findByid(long id);
}
