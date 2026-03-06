package org.demo.librarymanagementsystem.controller;

import org.demo.librarymanagementsystem.entity.Book;
import org.demo.librarymanagementsystem.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final LibraryService libraryService;
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Book> findAllBook() {
        return libraryService.findAllBook();
    }

    @GetMapping
    public Book findBookById(@RequestParam int id) {
        return libraryService.findBookById(id);
    }

    @GetMapping
    public List<Book> findBookByTitle(@RequestParam String title) {
        return libraryService.findBookByTitle(title);
    }

    @GetMapping
    public List<Book> findBookByAuthor(@RequestParam String author) {
        return libraryService.findBookByAuthor(author);
    }

}
