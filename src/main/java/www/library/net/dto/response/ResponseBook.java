package www.library.net.dto.response;

import lombok.Data;

@Data
public class ResponseBook {
    private String name;
    private String authorName;
    private int count;
    private String imageUrl;
}
