package www.library.net.service;


import org.springframework.web.multipart.MultipartFile;
import www.library.net.dto.request.BookRequest;
import www.library.net.dto.response.Response;
import www.library.net.dto.response.ResponseBook;
import www.library.net.dto.response.ResponseStatusList;
import www.library.net.entity.Book;
import www.library.net.exception.MyException;

import java.util.List;
import java.util.UUID;

public interface BookService {


    ResponseStatusList add(MultipartFile multipartFile, BookRequest bookRequest) throws Exception;

    List<Book> getList();

    Response<ResponseBook> getById(UUID uuid);
}
