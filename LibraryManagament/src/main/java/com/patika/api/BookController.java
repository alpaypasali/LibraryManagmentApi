package com.patika.api;

import com.patika.business.abstracts.IBookService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.requests.book.CreateBookRequest;
import com.patika.dto.requests.book.UpdateBookRequest;
import com.patika.dto.requests.bookBorrowing.CreateBookBorrowingRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import com.patika.dto.responses.book.BookResponse;
import com.patika.dto.responses.book.GetAllBookResponse;
import com.patika.dto.responses.book.GetBookResponse;
import com.patika.dto.responses.bookBorrowing.GetAllBookBorrowingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@AllArgsConstructor
public class BookController {
    private final IBookService bookService;
    @GetMapping()
    public DataResult<List<GetAllBookResponse>> getAll(){
        return this.bookService.getAll();
    }
    @PostMapping()
    public ResponseEntity<Result> create(@Valid @RequestBody CreateBookRequest createBookRequest){
        Result result = bookService.create(createBookRequest);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public DataResult<GetBookResponse> getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);


    }

    @PutMapping()
    public DataResult<BookResponse> update(@RequestBody UpdateBookRequest updateBookRequest){
        return bookService.update(updateBookRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        Result result = bookService.delete(id);
        return ResponseEntity.ok(result);
    }
}
