package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.BookBorrowingRepository;
import com.patika.dao.BookRepository;
import com.patika.entities.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookBorrowingBusinessRules {
        private  final BookBorrowingRepository bookBorrowingRepository;
        private final BookRepository bookRepository;

    public void checkIfBookBorrowingIdNotFind(int id) {
        if (!bookBorrowingRepository.existsById(id)) {
            throw new BusinessException("Book Borrwing with ID " + id + " does not find.");
        }
    }

    public void checkIfBookHaveAStock(int id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) {
            throw new BusinessException("Book with ID " + id + " does not exist.");
        }

        Book book = optionalBook.get();


        if (book.getStock() <= 0) {
            throw new BusinessException("Book with ID " + id + " does not have sufficient stock.");
        }
    }

}
