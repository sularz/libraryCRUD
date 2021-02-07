package com.example.secondCRUD.repository;

import com.example.secondCRUD.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository <Publisher, Integer> {
}
