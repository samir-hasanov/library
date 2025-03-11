package www.library.net.service;

import org.springframework.stereotype.Service;
import www.library.net.entity.Book;
import www.library.net.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBooks() {

        return repository.findAll();

    }
}
