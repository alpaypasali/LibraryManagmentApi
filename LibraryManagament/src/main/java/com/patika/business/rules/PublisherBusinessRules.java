package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublisherBusinessRules {
    private PublisherRepository publisherRepository ;
    public void checkIfPublisherNameExists(String name){
        if(this.publisherRepository.existsByPublisherName(name)){
            throw new BusinessException("Publisher name already exists");
        }
    }

    public void checkIfPublisherIdNotFind(int id) {
        if (!publisherRepository.existsById(id)) {
            throw new BusinessException("Publisher with ID " + id + " does not find.");
        }
    }
}
