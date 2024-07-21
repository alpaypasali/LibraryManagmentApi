package com.patika.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id" , columnDefinition = "serial")
    private  int id;

    @Column(name = "author_name" , nullable = false)
    private String authorName;

    @Column(name = "author_birthdate" , nullable = false)
    private  int authorBirthdate;

    @Column(name = "author_country" , nullable = false)
    private String authorCountry;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
