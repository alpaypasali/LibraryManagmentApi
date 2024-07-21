package com.patika.dto.requests.bookBorrowing;

import com.patika.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookBorrowingRequest {
    private  int borrowingId;

    private String  borrowerName;


    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private int bookId;
}
