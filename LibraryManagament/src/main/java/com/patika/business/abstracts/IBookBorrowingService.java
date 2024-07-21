package com.patika.business.abstracts;

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

import java.util.List;

public interface IBookBorrowingService {
    DataResult<List<GetAllBookBorrowingResponse>> getAll();
    Result create(CreateBookBorrowingRequest createBookBorrowingRequest);
    DataResult<BookBorrowingResponse> update(UpdateBookBorrowingRequest updateBookBorrowingRequest);
    Result delete(int id);
    DataResult<GetBookBorrowingResponse> getAuthorById(int id);
}
