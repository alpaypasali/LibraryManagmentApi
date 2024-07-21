package com.patika.dto.responses.bookBorrowing;

import com.patika.entities.Book;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private  int borrowingId;

    private String  borrowerName;


    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private Book book;
}
