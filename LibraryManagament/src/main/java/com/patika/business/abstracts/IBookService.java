package com.patika.business.abstracts;

import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.author.CreateAuthorRequest;
import com.patika.dto.requests.author.UpdateAuhtorRequest;
import com.patika.dto.requests.book.CreateBookRequest;
import com.patika.dto.requests.book.UpdateBookRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.author.GetAllAuthorResponse;
import com.patika.dto.responses.author.GetAuhtorResponse;
import com.patika.dto.responses.book.BookResponse;
import com.patika.dto.responses.book.GetAllBookResponse;
import com.patika.dto.responses.book.GetBookResponse;

import java.util.List;

public interface IBookService {

    DataResult<List<GetAllBookResponse>> getAll();
    Result create(CreateBookRequest createBookRequest);
    DataResult<BookResponse> update(UpdateBookRequest updateBookRequest);
    Result delete(int id);
    DataResult<GetBookResponse> getBookById(int id);
    void decreaseStock(int id);
    void increaseStock(int bookId);

}
