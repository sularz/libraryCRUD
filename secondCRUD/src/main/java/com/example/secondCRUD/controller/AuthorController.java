package com.example.secondCRUD.controller;

import com.example.secondCRUD.entity.Author;
import com.example.secondCRUD.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @GetMapping("authors")
    public String listAuthors(Model model){
        List<Author> listAuthors = repository.findAll();
        model.addAttribute("listAuthors", listAuthors);

        return "authors";
    }
}
