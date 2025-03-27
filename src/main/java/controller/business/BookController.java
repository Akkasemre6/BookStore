package controller.business;

import Entity.business.Book;
import Payload.Response.Business.BookResponse;
import Payload.Response.Business.ResponseMessage;
import Service.business.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Book")
@AllArgsConstructor
public class BookController {

    //TODO: CRUD

    private final BookService bookService;



    @PutMapping(path = "/createBook")
    public ResponseMessage<BookResponse> createBook(@RequestBody Book book){
        return bookService.createBook(book);

    }

    @GetMapping(path = "/getAllBooks")
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/getBookById/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PatchMapping(path = "/updateBook/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable long id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    @DeleteMapping(path = "/deleteBook/{id}")
    public String deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }
}
