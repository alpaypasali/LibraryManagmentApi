package com.patika.business.concretes;

import com.patika.business.abstracts.IBookService;
import com.patika.business.abstracts.ICategoryService;
import com.patika.business.rules.BookBusinessRules;
import com.patika.core.utilities.mappers.ModelMapperService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.core.utilities.results.SuccessDataResult;
import com.patika.core.utilities.results.SuccessResult;
import com.patika.dao.BookRepository;
import com.patika.dto.requests.book.CreateBookRequest;
import com.patika.dto.requests.book.UpdateBookRequest;
import com.patika.dto.responses.author.AuthorResponse;
import com.patika.dto.responses.book.BookResponse;
import com.patika.dto.responses.book.GetAllBookResponse;
import com.patika.dto.responses.book.GetBookResponse;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.publisher.PublisherResponse;
import com.patika.entities.Book;
import com.patika.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookManager implements IBookService {

    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;
    private final ICategoryService categoryService;
    private final BookBusinessRules rules;
    @Override
    public DataResult<List<GetAllBookResponse>> getAll() {
        List<Book> books = bookRepository.findAll();

        List<GetAllBookResponse> bookResponses = books.stream()
                .map(book -> {
                    AuthorResponse authorDTO = modelMapperService.forResponse().map(book.getAuthor(), AuthorResponse.class);
                    PublisherResponse publisherDTO = modelMapperService.forResponse().map(book.getPublisher(), PublisherResponse.class);
                    List<CategoryResponse> categoryDTOs = book.getCategories().stream()
                            .map(category -> modelMapperService.forResponse().map(category, CategoryResponse.class))
                            .collect(Collectors.toList());

                    return new GetAllBookResponse(
                            book.getBookId(),
                            book.getBookName(),
                            book.getBookPublicationYear(),
                            book.getStock(),
                            authorDTO,
                            publisherDTO,
                            categoryDTOs
                    );
                })
                .collect(Collectors.toList());

        return new SuccessDataResult<>(bookResponses);
    }

    @Override
    public Result create(CreateBookRequest createBookRequest) {

        Book book = modelMapperService.forRequest().map(createBookRequest, Book.class);

        List<Category> categories = categoryService.getCategoriesByIds(createBookRequest.getCategoryIds());
        book.setCategories(categories);
        bookRepository.save(book);
        return new SuccessResult("Book added successfully");
    }

    @Override
    public DataResult<BookResponse> update(UpdateBookRequest updateBookRequest) {
        rules.checkIfBookBookIdNotFind(updateBookRequest.getBookId());
        Book existingBook = this.bookRepository.getById(updateBookRequest.getBookId());
        List<Category> categories = categoryService.getCategoriesByIds(updateBookRequest.getCategoryIds());
        this.modelMapperService.forRequest().map(updateBookRequest, existingBook);
        existingBook.setCategories(categories);
        this.bookRepository.save(existingBook);
        BookResponse response = this.modelMapperService.forResponse().map(existingBook, BookResponse.class);

        return new SuccessDataResult<>(response, "Book updated successfully");
    }

    @Override
    public Result delete(int id) {
        rules.checkIfBookBookIdNotFind(id);
        Book deletedBook = this.bookRepository.getById(id);
        this.bookRepository.delete(deletedBook);
        return new SuccessResult("Book Borrowing deleted");
    }

    @Override
    public DataResult<GetBookResponse> getBookById(int id) {
        rules.checkIfBookBookIdNotFind(id);
        Book existingBook = this.bookRepository.getById(id);
        GetBookResponse response = this.modelMapperService.forResponse().map(existingBook, GetBookResponse.class);
        return new SuccessDataResult<>(response);
    }
    @Override
    public void decreaseStock(int id){
        rules.checkIfBookBookIdNotFind(id);
        Book book = bookRepository.getById(id);
        book.setStock(book.getStock() - 1);
        bookRepository.save(book);
    }

    @Override
    public void increaseStock(int bookId) {
        rules.checkIfBookBookIdNotFind(bookId);
        Book book = bookRepository.getById(bookId);
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);

    }
}
