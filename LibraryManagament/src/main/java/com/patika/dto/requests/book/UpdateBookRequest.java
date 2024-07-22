package com.patika.dto.requests.book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UpdateBookRequest {
    private int bookId;
    private String bookName;
    private int bookPublicationYear;
    private int stock;
    private int authorId;
    private int publisherId;
    private List<Integer> categoryIds;
}
