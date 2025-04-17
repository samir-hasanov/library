package www.library.net.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import www.library.net.dto.request.BookRequest;
import www.library.net.dto.response.Response;
import www.library.net.dto.response.ResponseBook;
import www.library.net.dto.response.ResponseStatus;
import www.library.net.dto.response.ResponseStatusList;
import www.library.net.entity.Book;
import www.library.net.exception.ExceptionConstants;
import www.library.net.exception.MyException;
import www.library.net.repository.BookRepository;
import www.library.net.service.BookService;
import www.library.net.service.FileService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private FileService service;
    @Autowired
    private BookRepository repository;

    private static String bucket = "book";


    @Override
    public ResponseStatusList add(MultipartFile multipartFile, BookRequest bookRequest) throws Exception {
        ResponseStatusList response = new ResponseStatusList();
        try {

            if (multipartFile != null && bookRequest != null) {

                String imageUrl = service.uploadToMinio(multipartFile, bucket);
                Book book = new Book();
                book.setName(bookRequest.getName());
                book.setAuthorName(bookRequest.getAuthorName());
                book.setCount(bookRequest.getCount());
                book.setImageUrl(imageUrl);
                repository.save(book);
                response.setStatus(ResponseStatus.getMessage());
                return response;

            } else {
                throw new MyException(ExceptionConstants.REQUEST_NULL, "Request can not be aue");
            }


        } catch (MyException e) {
            response.setStatus(new ResponseStatus(e.getCode(), e.getMessage()));

        } catch (Exception e) {
            response.setStatus(new ResponseStatus(ExceptionConstants.SERVER_ERROR, "Internal 500"));
        }
        return response;
    }

    @Override
    public List<Book> getList() {
        return repository.findAll();
    }

    @Override
    public Response<ResponseBook> getById(UUID uuid) {
        Response response = new Response();
        try {
            Book book = repository.findByDeletedFalseAndUuid(uuid);
            if (book != null) {
                ResponseBook responseBook = new ResponseBook();
                responseBook.setName(book.getName());
                responseBook.setAuthorName(book.getAuthorName());
                responseBook.setImageUrl(book.getImageUrl());
                responseBook.setCount(book.getCount());
                response.setT(responseBook);
                response.setStatus(ResponseStatus.getMessage());
                return response;
            } else {
                throw new MyException(ExceptionConstants.NOT_FOUND, "Book not found");
            }

        } catch (MyException e) {
            response.setStatus(new ResponseStatus(e.getCode(), e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
