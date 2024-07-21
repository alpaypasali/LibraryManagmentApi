package com.patika.api;

import com.patika.business.abstracts.IPublisherService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.publisher.CreatePublisherRequest;
import com.patika.dto.requests.publisher.UpdatePublisherRequest;
import com.patika.dto.responses.publisher.GetAllPublisherResponse;
import com.patika.dto.responses.publisher.GetPublisherResponse;
import com.patika.dto.responses.publisher.PublisherResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publishers")
@AllArgsConstructor
public class PublisherController {
    private  final IPublisherService publisherService;

    @GetMapping()
    public DataResult<List<GetAllPublisherResponse>> getAll(){
        return this.publisherService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetPublisherResponse> getPublisher(@PathVariable("id") int id){
        return publisherService.getPublisherById(id);


    }

    @PostMapping()
    public ResponseEntity<Result> create(@Valid @RequestBody CreatePublisherRequest createPublisherRequest){
        Result result = publisherService.create(createPublisherRequest);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public DataResult<PublisherResponse> update(@RequestBody UpdatePublisherRequest updatePublisherRequest){
        return publisherService.update(updatePublisherRequest);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        Result result = publisherService.delete(id);
        return ResponseEntity.ok(result);
    }
}
