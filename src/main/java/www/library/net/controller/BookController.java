package www.library.net.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.library.net.entity.Book;
import www.library.net.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    public BookController(BookService service) {
        this.service = service;
    }

    private BookService service;

    @GetMapping("/list")
    public List<Book> bookList(){

        return service.getBooks();
    }
}
