package com.patika.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id" , columnDefinition = "serial")
    private  int publisherId;

    @Column(name = "publisher_name" , nullable = false)
    private String publisherName;

    @Column(name = "publisher_establishment_year", nullable = false)
    private int publisherEstablishmentYear;

    @Column(name = "publisher_address" , nullable = false)
    private String publisherAddress;

    @OneToMany(mappedBy = "publisher" , cascade = CascadeType.ALL)
    private List<Book> books;

}
