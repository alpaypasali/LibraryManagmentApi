package com.patika.business.abstracts;

import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.category.CreateCategoryRequest;
import com.patika.dto.requests.category.UpdateCategoryRequest;
import com.patika.dto.requests.publisher.CreatePublisherRequest;
import com.patika.dto.requests.publisher.UpdatePublisherRequest;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;
import com.patika.dto.responses.publisher.GetAllPublisherResponse;
import com.patika.dto.responses.publisher.GetPublisherResponse;
import com.patika.dto.responses.publisher.PublisherResponse;

import java.util.List;

public interface IPublisherService {

    DataResult<List<GetAllPublisherResponse>> getAll();
    Result create(CreatePublisherRequest createPublisherRequest);
    DataResult<PublisherResponse> update(UpdatePublisherRequest updatePublisherRequest);
    Result delete(int id);
    DataResult<GetPublisherResponse> getPublisherById(int id);
}
