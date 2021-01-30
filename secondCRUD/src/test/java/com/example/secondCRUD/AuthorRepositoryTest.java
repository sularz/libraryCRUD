package com.example.secondCRUD;

import static  org.assertj.core.api.Assertions.assertThat;

import com.example.secondCRUD.entity.Author;
import com.example.secondCRUD.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false) //przywracanie
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository repository;

    @Test
    public  void testCreateAuthor(){
        Author save = repository.save(new Author("Eleonora", "Nowacka"));

        assertThat(save.getId()).isGreaterThan(0);
    }
}
