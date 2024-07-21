package com.patika.business.concretes;

import com.patika.business.abstracts.ICategoryService;
import com.patika.business.rules.CategoryBusinessRules;
import com.patika.core.utilities.mappers.ModelMapperService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.core.utilities.results.SuccessDataResult;
import com.patika.core.utilities.results.SuccessResult;
import com.patika.dao.CategoryRepository;
import com.patika.dto.requests.category.CreateCategoryRequest;
import com.patika.dto.requests.category.UpdateCategoryRequest;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;
import com.patika.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements ICategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private CategoryBusinessRules rules;


    @Override
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoryResponse> getAllCategoryResponses = categories.stream()
                .map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoryResponse.class))
                .toList();

        return new SuccessDataResult<>(getAllCategoryResponses);
    }

    @Override
    public Result create(CreateCategoryRequest createCategoryRequest) {
        this.rules.checkIfCategoryNameExists(createCategoryRequest.getCategoryName());
        Category category = this.modelMapperService.forRequest()
                .map(createCategoryRequest , Category.class);

        this.categoryRepository.save(category);
        return new SuccessResult("Category added");
    }

    @Override
    public DataResult<CategoryResponse> update(UpdateCategoryRequest updateCategoryRequest) {
        this.rules.checkIfCategoryIdNotFind(updateCategoryRequest.getId());
        Category existingCategory = this.categoryRepository.getById(updateCategoryRequest.getId());
        this.modelMapperService.forRequest().map(updateCategoryRequest, existingCategory);

        this.categoryRepository.save(existingCategory);
        CategoryResponse response = this.modelMapperService.forResponse().map(existingCategory, CategoryResponse.class);
        return new SuccessDataResult<>(response, "Category updated successfully");
    }

    @Override
    public Result delete(int id) {
        this.rules.checkIfCategoryIdNotFind(id);
        Category deleteCategory = this.categoryRepository.getById(id);
        this.categoryRepository.delete(deleteCategory);
        return new SuccessResult("Category deleted");
    }
    @Override
    public DataResult<GetCategoryResponse> getCategoryById(int id){
        this.rules.checkIfCategoryIdNotFind(id);
        Category existingCategory = this.categoryRepository.getById(id);
        GetCategoryResponse response = this.modelMapperService.forResponse().map(existingCategory, GetCategoryResponse.class);
        return new SuccessDataResult<>(response);
    }

}
