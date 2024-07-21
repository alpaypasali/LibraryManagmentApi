package com.patika.business.concretes;

import com.patika.business.abstracts.IAuthorService;
import com.patika.business.rules.AuthorBusinessRules;
import com.patika.core.utilities.mappers.ModelMapperService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.core.utilities.results.SuccessDataResult;
import com.patika.core.utilities.results.SuccessResult;
import com.patika.dao.AuthorRepository;
import com.patika.dto.requests.author.CreateAuthorRequest;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAllAuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import com.patika.entities.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AuthorManager implements IAuthorService {
    private final AuthorRepository authorRepository;
    private  final ModelMapperService modelMapperService;
    private  final AuthorBusinessRules rules;
    @Override
    public DataResult<List<GetAllAuthorResponse>> getAll() {
        List<Author> authors = authorRepository.findAll();

        List<GetAllAuthorResponse> getAllAuthorResponses = authors.stream()
                .map(author -> this.modelMapperService.forResponse().map(author, GetAllAuthorResponse.class))
                .toList();

        return new SuccessDataResult<>(getAllAuthorResponses);
    }

    @Override
    public Result create(CreateAuthorRequest createAuthorRequest) {
        this.rules.checkIfAuthorNameExists(createAuthorRequest.getAuthorName());
        Author author = this.modelMapperService.forRequest()
                .map(createAuthorRequest , Author.class);

        this.authorRepository.save(author);
        return new SuccessResult("Author added");
    }

    @Override
    public DataResult<AuthorResponse> update(UpdateAuhtorRequest updateAuhtorRequest) {
        this.rules.checkIfAuthorIdNotFind(updateAuhtorRequest.getId());
        Author existingAuthor = this.authorRepository.getById(updateAuhtorRequest.getId());
        this.modelMapperService.forRequest().map(updateAuhtorRequest, existingAuthor);

        this.authorRepository.save(existingAuthor);
        AuthorResponse response = this.modelMapperService.forResponse().map(existingAuthor, AuthorResponse.class);
        return new SuccessDataResult<>(response, "Author updated successfully");
    }

    @Override
    public Result delete(int id) {
        this.rules.checkIfAuthorIdNotFind(id);
        Author deletedAuthor = this.authorRepository.getById(id);
        this.authorRepository.delete(deletedAuthor);
        return new SuccessResult("Author deleted");
    }

    @Override
    public DataResult<GetAuhtorResponse> getAuthorById(int id) {
        this.rules.checkIfAuthorIdNotFind(id);
        Author existingAuthor = this.authorRepository.getById(id);
        GetAuhtorResponse response = this.modelMapperService.forResponse().map(existingAuthor, GetAuhtorResponse.class);
        return new SuccessDataResult<>(response);
    }
}
