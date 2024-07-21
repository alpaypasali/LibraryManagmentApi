package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorBusinessRules {
    private final AuthorRepository authorRepository;
    public void checkIfAuthorNameExists(String name){
        if(this.authorRepository.existsByAuthorName(name)){
            throw new BusinessException("Author name already exists");
        }
    }

    public void checkIfAuthorIdNotFind(int id) {
        if (!authorRepository.existsById(id)) {
            throw new BusinessException("Author with ID " + id + " does not find.");
        }
    }
}
