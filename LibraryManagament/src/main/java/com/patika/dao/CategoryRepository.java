package com.patika.dao;

import com.patika.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {
    boolean existsByCategoryName(String categoryName);
}
