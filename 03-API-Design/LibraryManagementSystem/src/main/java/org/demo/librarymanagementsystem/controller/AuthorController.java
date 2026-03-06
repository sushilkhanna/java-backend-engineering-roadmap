package org.demo.librarymanagementsystem.controller;

import org.demo.librarymanagementsystem.entity.Author;
import org.demo.librarymanagementsystem.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final LibraryService service;
    private AuthorController(LibraryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> findAllAuthor() {
        return service.findAllAuthor();
    }

}
