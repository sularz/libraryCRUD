package com.example.secondCRUD.controller;

import com.example.secondCRUD.entity.Author;
import com.example.secondCRUD.entity.Book;
import com.example.secondCRUD.entity.Publisher;
import com.example.secondCRUD.repository.AuthorRepository;
import com.example.secondCRUD.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/publishers")
    public  String listPublishers(Model model){
        List<Publisher> listPublishers = publisherRepository.findAll();

        model.addAttribute("listPublishers", listPublishers);
        return "books";

    }

    @GetMapping("/publishers/new")
    public String showCreatedPublisherForm(Model model){
        List<Author> listAuthors = authorRepository.findAll();

        model.addAttribute("listAuthors", listAuthors);
        model.addAttribute("publisher", new Publisher());

        return "publisher_form";
    }

    @PostMapping("/publishers/save")
    public String savePublisher(Publisher publisher){
        publisherRepository.save(publisher);
        return  "redirect:/publishers";
    }
}
