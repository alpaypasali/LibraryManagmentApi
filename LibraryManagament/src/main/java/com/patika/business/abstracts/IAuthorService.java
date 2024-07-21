package com.patika.business.abstracts;

import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.author.CreateAuthorRequest;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.requests.category.CreateCategoryRequest;
import com.patika.dto.requests.category.UpdateCategoryRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAllAuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;

import java.util.List;

public interface IAuthorService {
    DataResult<List<GetAllAuthorResponse>> getAll();
    Result create(CreateAuthorRequest createAuthorRequest);
    DataResult<AuthorResponse> update(UpdateAuhtorRequest updateAuhtorRequest);
    Result delete(int id);
    DataResult<GetAuhtorResponse> getAuthorById(int id);
}
