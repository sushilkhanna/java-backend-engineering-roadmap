package org.demo.librarymanagementsystem.repository;

import org.demo.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {

    List<Book> findBookByTitle(@RequestParam String author);

    List<Book> findBookByAuthor_Name(@RequestParam String name);
}
