package com.patika.business.abstracts;

import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.category.CreateCategoryRequest;
import com.patika.dto.requests.category.UpdateCategoryRequest;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;


import java.util.List;

public interface ICategoryService {

    DataResult<List<GetAllCategoryResponse>> getAll();
    Result create(CreateCategoryRequest createCategoryRequest);
    DataResult<CategoryResponse> update(UpdateCategoryRequest updateCategoryRequest);
    Result delete(int id);
    DataResult<GetCategoryResponse> getCategoryById(int id);
    }
