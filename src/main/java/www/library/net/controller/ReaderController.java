package www.library.net.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.library.net.entity.Reader;

import java.util.List;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    @GetMapping
    public List<Reader> getReaders(){/// murad and Hamlet

        return null;
    }
}
