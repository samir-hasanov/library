package www.library.net.dto.request;

import lombok.Data;

@Data
public class BookRequest {

    private String name;
    private String authorName;
    private int count;

}
