package com.patika.dto.requests.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookBorrowingRequest {
    private  int borrowingId;

    private String  borrowerName;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private int bookId;
}
