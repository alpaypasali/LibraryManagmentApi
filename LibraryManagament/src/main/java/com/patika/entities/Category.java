package com.patika.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id" , columnDefinition = "serial")
    private  int categoryId;

    @Column(name = "category_name" , nullable = false)
    private String categoryName;

    @Column(name = "category_description")
    private  String categoryDescription;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
