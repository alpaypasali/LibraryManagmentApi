package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.BookBorrowingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookBorrowingBusinessRules {
        private  final BookBorrowingRepository bookBorrowingRepository;

    public void checkIfBookBorrowingIdNotFind(int id) {
        if (!bookBorrowingRepository.existsById(id)) {
            throw new BusinessException("Book Borrwing with ID " + id + " does not find.");
        }
    }

    //Duzenle Book repository sonra!
    public void checkIfBookHaveAStock(int id) {
        if (!bookBorrowingRepository.existsById(id)) {
            throw new BusinessException("Book Borrwing with ID " + id + " does not find.");
        }
    }

}
