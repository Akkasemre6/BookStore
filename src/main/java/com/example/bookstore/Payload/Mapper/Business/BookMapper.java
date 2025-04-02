package com.example.bookstore.Payload.Mapper.Business;


import com.example.bookstore.Entity.business.Book;
import com.example.bookstore.Payload.Request.business.BookUpdateRequest;
import com.example.bookstore.Payload.Response.Business.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static BookResponse mapBookToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .price(book.getPrice())
                .publisher(book.getPublisher())
                .imageUrl(book.getImageUrl())
                .description(book.getDescription())
                .build();
    }

    public static Book mapBookUpdateRequestToBook(BookUpdateRequest request) {
        return Book.builder()
                .bookName(request.getBookName())
                .author(request.getAuthor())
                .publisher(request.getPublisher())
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

}
