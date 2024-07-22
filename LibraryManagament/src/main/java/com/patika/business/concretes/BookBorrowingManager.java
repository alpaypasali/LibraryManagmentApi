package com.patika.business.concretes;

import com.patika.business.abstracts.IBookBorrowingService;
import com.patika.business.abstracts.IBookService;
import com.patika.business.rules.BookBorrowingBusinessRules;
import com.patika.core.utilities.mappers.ModelMapperService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.core.utilities.results.SuccessDataResult;
import com.patika.core.utilities.results.SuccessResult;
import com.patika.dao.BookBorrowingRepository;
import com.patika.dto.requests.bookBorrowing.CreateBookBorrowingRequest;
import com.patika.dto.requests.bookBorrowing.UpdateBookBorrowingRequest;
import com.patika.dto.responses.bookBorrowing.BookBorrowingResponse;
import com.patika.dto.responses.bookBorrowing.GetAllBookBorrowingResponse;
import com.patika.dto.responses.bookBorrowing.GetBookBorrowingResponse;
import com.patika.entities.BookBorrowing;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BookBorrowingManager implements IBookBorrowingService {
    private final BookBorrowingRepository bookBorrowingRepository;
    private  final ModelMapperService modelMapperService;
    private  final IBookService bookService;
    private  final BookBorrowingBusinessRules rules;

    @Override
    public DataResult<List<GetAllBookBorrowingResponse>> getAll() {
        List<BookBorrowing> bookBorrowings = bookBorrowingRepository.findAll();

        List<GetAllBookBorrowingResponse> getAllBookBorrowingResponses = bookBorrowings.stream()
                .map(bookBorrowing -> this.modelMapperService.forResponse().map(bookBorrowing, GetAllBookBorrowingResponse.class))
                .toList();

        return new SuccessDataResult<>(getAllBookBorrowingResponses);
    }

    @Override
    public Result create(CreateBookBorrowingRequest createBookBorrowingRequest) {
        rules.checkIfBookHaveAStock(createBookBorrowingRequest.getBookId());
        BookBorrowing bookBorrowing = this.modelMapperService.forRequest()
                .map(createBookBorrowingRequest , BookBorrowing.class);

        this.bookBorrowingRepository.save(bookBorrowing);
        this.bookService.decreaseStock(createBookBorrowingRequest.getBookId());
        return new SuccessResult("Book Borrowing added");
    }

    @Override
    public DataResult<BookBorrowingResponse> update(UpdateBookBorrowingRequest updateBookBorrowingRequest) {
        this.rules.checkIfBookBorrowingIdNotFind(updateBookBorrowingRequest.getBorrowingId());
        rules.checkIfBookHaveAStock(updateBookBorrowingRequest.getBookId());
        BookBorrowing existingBookBorrowing = this.bookBorrowingRepository.getById(updateBookBorrowingRequest.getBorrowingId());
        this.modelMapperService.forRequest().map(updateBookBorrowingRequest, existingBookBorrowing);

        this.bookBorrowingRepository.save(existingBookBorrowing);
        BookBorrowingResponse response = this.modelMapperService.forResponse().map(existingBookBorrowing, BookBorrowingResponse.class);
        return new SuccessDataResult<>(response, "Book Borrowing updated successfully");
    }

    @Override
    public Result delete(int id) {
        this.rules.checkIfBookBorrowingIdNotFind(id);
        BookBorrowing deletedBookBorrowing = this.bookBorrowingRepository.getById(id);
        this.bookBorrowingRepository.delete(deletedBookBorrowing);
        this.bookService.increaseStock(deletedBookBorrowing.getBook().getBookId());
        return new SuccessResult("Book Borrowing deleted");
    }

    @Override
    public DataResult<GetBookBorrowingResponse> getAuthorById(int id) {
        this.rules.checkIfBookBorrowingIdNotFind(id);
        BookBorrowing existingBookBorrowing = this.bookBorrowingRepository.getById(id);
        GetBookBorrowingResponse response = this.modelMapperService.forResponse().map(existingBookBorrowing, GetBookBorrowingResponse.class);
        return new SuccessDataResult<>(response);
    }
}
