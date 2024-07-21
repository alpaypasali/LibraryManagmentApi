package com.patika.dao;

import com.patika.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher , Integer> {
    boolean existsByPublisherName(String publisherName);
}
