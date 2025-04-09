package www.library.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.library.net.entity.Author;
import www.library.net.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

}
