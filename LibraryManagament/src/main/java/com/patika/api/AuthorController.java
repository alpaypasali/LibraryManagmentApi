package com.patika.api;

import com.patika.business.abstracts.IAuthorService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.author.CreateAuthorRequest;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAllAuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/authors")
@AllArgsConstructor
public class AuthorController {
    private  final IAuthorService authorService;

    @GetMapping()
    public DataResult<List<GetAllAuthorResponse>> getAll(){
        return this.authorService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetAuhtorResponse> getAuthor(@PathVariable("id") int id){
        return authorService.getAuthorById(id);


    }

    @PostMapping()
    public ResponseEntity<Result> create(@Valid @RequestBody CreateAuthorRequest createAuthorRequest){
        Result result = authorService.create(createAuthorRequest);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public DataResult<AuthorResponse> update(@RequestBody UpdateAuhtorRequest updateAuhtorRequest){
        return authorService.update(updateAuhtorRequest);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        Result result = authorService.delete(id);
        return ResponseEntity.ok(result);
    }
}
