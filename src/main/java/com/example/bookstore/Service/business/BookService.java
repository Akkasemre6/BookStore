package com.example.bookstore.Service.business;


import com.example.bookstore.Entity.business.Book;
import com.example.bookstore.Payload.Mapper.Business.BookMapper;
import com.example.bookstore.Payload.Messages.ErrorMessages;
import com.example.bookstore.Payload.Messages.SuccessMessages;
import com.example.bookstore.Payload.Response.Business.BookResponse;
import com.example.bookstore.Payload.Response.Business.ResponseMessage;
import com.example.bookstore.Repository.business.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;

    public ResponseMessage<BookResponse> createBook(Book book) {
        Book createBook = new Book();
        createBook.setBookName(book.getBookName());
        createBook.setImageUrl(book.getImageUrl());
        createBook.setPrice(book.getPrice());
        createBook.setAuthor(book.getAuthor());
        createBook.setPublisher(book.getPublisher());
        bookRepository.save(createBook);
        return ResponseMessage.<BookResponse>builder()
                .httpStatus(HttpStatus.CREATED)
                .object(BookMapper.mapBookToBookResponse(createBook))
                .message(SuccessMessages.BOOK_CREATED)
                .build();
    }


    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<BookResponse> response = books.stream().map(BookMapper::mapBookToBookResponse).toList();
        return ResponseEntity.ok(response);

    }

    public ResponseEntity<BookResponse> getBookById(long id) {
        if (findBookById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(BookMapper.mapBookToBookResponse(findBookById(id)));
    }

    public ResponseEntity<BookResponse> updateBook(long id, Book book) {
        if (findBookById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Book updateBook = bookRepository.getById(id);
        return ResponseEntity.ok(BookMapper.mapBookToBookResponse(updateBook));
    }

    public String deleteBook(long id) {
        if (findBookById(id) == null) {
            return ErrorMessages.Book_NOT_FOUND;
        }
        bookRepository.deleteById(id);
        return SuccessMessages.BOOK_DELETED;
    }

    Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
