package com.patika.business.concretes;

import com.patika.business.abstracts.IPublisherService;
import com.patika.business.rules.PublisherBusinessRules;
import com.patika.core.utilities.mappers.ModelMapperService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.core.utilities.results.SuccessDataResult;
import com.patika.core.utilities.results.SuccessResult;
import com.patika.dao.PublisherRepository;
import com.patika.dto.requests.publisher.CreatePublisherRequest;
import com.patika.dto.requests.publisher.UpdatePublisherRequest;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;
import com.patika.dto.responses.publisher.GetAllPublisherResponse;
import com.patika.dto.responses.publisher.GetPublisherResponse;
import com.patika.dto.responses.publisher.PublisherResponse;
import com.patika.entities.Category;
import com.patika.entities.Publisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PublisherManager implements IPublisherService {

    private  final PublisherRepository publisherRepository;
    private  final ModelMapperService modelMapperService;
    private  final PublisherBusinessRules rules;
    @Override
    public DataResult<List<GetAllPublisherResponse>> getAll() {
        List<Publisher> publishers = publisherRepository.findAll();

        List<GetAllPublisherResponse> getAllPublisherResponses = publishers.stream()
                .map(publisher -> this.modelMapperService.forResponse().map(publisher, GetAllPublisherResponse.class))
                .toList();

        return new SuccessDataResult<>(getAllPublisherResponses);
    }

    @Override
    public Result create(CreatePublisherRequest createPublisherRequest) {
        this.rules.checkIfPublisherNameExists(createPublisherRequest.getPublisherName());
        Publisher publisher = this.modelMapperService.forRequest()
                .map(createPublisherRequest, Publisher.class);

        this.publisherRepository.save(publisher);
        return new SuccessResult("Publisher added");
    }

    @Override
    public DataResult<PublisherResponse> update(UpdatePublisherRequest updatePublisherRequest) {
        this.rules.checkIfPublisherIdNotFind(updatePublisherRequest.getPublisherId());
        Publisher existingPublisher = this.publisherRepository.getById(updatePublisherRequest.getPublisherId());
        this.modelMapperService.forRequest().map(updatePublisherRequest, existingPublisher);

        this.publisherRepository.save(existingPublisher);
        PublisherResponse response = this.modelMapperService.forResponse().map(existingPublisher, PublisherResponse.class);
        return new SuccessDataResult<>(response, "Publisher updated successfully");
    }

    @Override
    public Result delete(int id) {
        this.rules.checkIfPublisherIdNotFind(id);
        Publisher deletedPublisher = this.publisherRepository.getById(id);
        this.publisherRepository.delete(deletedPublisher);
        return new SuccessResult("Publisher deleted");
    }

    @Override
    public DataResult<GetPublisherResponse> getPublisherById(int id) {
        this.rules.checkIfPublisherIdNotFind(id);
        Publisher existingPublisher = this.publisherRepository.getById(id);
        GetPublisherResponse response = this.modelMapperService.forResponse().map(existingPublisher, GetPublisherResponse.class);
        return new SuccessDataResult<>(response);
    }
}
