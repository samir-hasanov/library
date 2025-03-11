package www.library.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.library.net.entity.Author;
import www.library.net.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public List<Author> getList() {

    return repository.findAll();
    }
}
