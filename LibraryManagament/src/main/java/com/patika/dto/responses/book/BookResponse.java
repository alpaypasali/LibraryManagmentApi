package com.patika.dto.responses.book;

import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.publisher.PublisherResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int bookId;
    private String bookName;
    private int bookPublicationYear;
    private int stock;
    private AuthorResponse author;
    private PublisherResponse publisher;
    private List<CategoryResponse> categories;
}
