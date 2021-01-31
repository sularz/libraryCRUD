package com.example.secondCRUD.controller;

import com.example.secondCRUD.entity.Author;
import com.example.secondCRUD.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping("authors")
    @RequestMapping("authors")
    public String listAuthors(Model model){
        List<Author> listAuthors = repository.findAll();
        model.addAttribute("listAuthors", listAuthors);

        return "authors";
    }

    @GetMapping("/authors/new")
    public String showAuthorNewForm(Model model){
        model.addAttribute("author", new Author());
        return "author_form";
    }

    @PostMapping("/authors/save")
    public String saveAuthor(Author author){
        repository.save(author);
        return "redirect:/";
    }
}
