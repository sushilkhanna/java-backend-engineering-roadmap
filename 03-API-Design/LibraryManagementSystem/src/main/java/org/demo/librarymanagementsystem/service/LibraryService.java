package org.demo.librarymanagementsystem.service;

import org.demo.librarymanagementsystem.entity.Author;
import org.demo.librarymanagementsystem.entity.Book;
import org.demo.librarymanagementsystem.repository.AuthorRepo;
import org.demo.librarymanagementsystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    public LibraryService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }



    public List<Author> findAllAuthor() {
        return authorRepo.findAll();
    }


    public List<Book> findAllBook() {
        return bookRepo.findAll();
    }
    public Book findBookById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Book Not Found by ID: " + id));
    }
    public List<Book> findBookByTitle(String title) {
        return bookRepo.findBookByTitle(title);
    }
    public List<Book> findBookByAuthor(String author) {
        return bookRepo.findBookByAuthor_Name(author);
    }
}
