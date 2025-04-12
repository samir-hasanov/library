package www.library.net.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import www.library.net.dto.request.BookRequest;
import www.library.net.dto.response.Response;
import www.library.net.dto.response.ResponseBook;
import www.library.net.dto.response.ResponseStatusList;
import www.library.net.entity.Book;
import www.library.net.service.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService service;


    @PostMapping("/add")
    public ResponseStatusList add(
            @RequestPart("multipartFile") MultipartFile multipartFile,
            @RequestPart("reqBook") String reqBook) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        BookRequest bookRequest = objectMapper.readValue(reqBook, BookRequest.class);

        return service.add(multipartFile, bookRequest);
    }


    @GetMapping("/{uuid}")
    private Response<ResponseBook> getById(@PathVariable UUID uuid) {

        return service.getById(uuid);
    }


    @GetMapping
    public List<Book> getList(){

       return service.getList();
    }


}
