package com.example.secondCRUD.controller;

import com.example.secondCRUD.entity.Author;
import com.example.secondCRUD.entity.Book;
import com.example.secondCRUD.repository.AuthorRepository;
import com.example.secondCRUD.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books/new")
    public String showNewBooks(Model model){
        List<Author> listAuthors = authorRepository.findAll();

        model.addAttribute("book", new Book());
        model.addAttribute("listAuthors", listAuthors);
       return "book_form";
    }
    @PostMapping("/books/save")
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:/";
    }

    @GetMapping("/books")
    public  String listBooks(Model model){
        List<Book> listBooks = repository.findAll();
        model.addAttribute("", listBooks);
        return "books";
    }
}
