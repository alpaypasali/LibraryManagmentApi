package com.patika.business.rules;

import com.patika.core.utilities.exceptions.BusinessException;
import com.patika.dao.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;
    public void checkIfCategoryNameExists(String name){
        if(this.categoryRepository.existsByCategoryName(name)){
            throw new BusinessException("Category name already exists");
        }
    }

    public void checkIfCategoryIdNotFind(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new BusinessException("Category with ID " + id + " does not find.");
        }
    }
}
