package com.patika.api;

import com.patika.business.abstracts.IAuthorService;
import com.patika.business.abstracts.IBookBorrowingService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.author.CreateAuthorRequest;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.requests.bookBorrowing.CreateBookBorrowingRequest;
import com.patika.dto.requests.bookBorrowing.UpdateBookBorrowingRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAllAuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import com.patika.dto.responses.bookBorrowing.BookBorrowingResponse;
import com.patika.dto.responses.bookBorrowing.GetAllBookBorrowingResponse;
import com.patika.dto.responses.bookBorrowing.GetBookBorrowingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/bookBorrowings")
@AllArgsConstructor
public class BookBorrowingController {
    private  final IBookBorrowingService bookBorrowingService;

    @GetMapping()
    public DataResult<List<GetAllBookBorrowingResponse>> getAll(){
        return this.bookBorrowingService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetBookBorrowingResponse> getBookBorrowing(@PathVariable("id") int id){
        return bookBorrowingService.getAuthorById(id);


    }

    @PostMapping()
    public ResponseEntity<Result> create(@Valid @RequestBody CreateBookBorrowingRequest createBookBorrowingRequest){
        Result result = bookBorrowingService.create(createBookBorrowingRequest);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public DataResult<BookBorrowingResponse> update(@RequestBody UpdateBookBorrowingRequest updateBookBorrowingRequest){
        return bookBorrowingService.update(updateBookBorrowingRequest);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        Result result = bookBorrowingService.delete(id);
        return ResponseEntity.ok(result);
    }
}
