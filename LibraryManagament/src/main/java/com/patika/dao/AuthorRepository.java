package com.patika.dao;

import com.patika.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Integer> {
    boolean existsByAuthorName(String authorName);
}
