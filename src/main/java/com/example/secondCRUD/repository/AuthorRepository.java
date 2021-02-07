package com.example.secondCRUD.repository;

import com.example.secondCRUD.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
