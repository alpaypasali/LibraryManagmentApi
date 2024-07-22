package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookBusinessRules {
    private final BookRepository bookRepository;
    public void checkIfBookBookIdNotFind(int id) {
        if (!bookRepository.existsById(id)) {
            throw new BusinessException("Book with ID " + id + " does not find.");
        }
    }
}
