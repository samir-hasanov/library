package www.library.net.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseStatusList {
    @JsonProperty(value ="status")
    private ResponseStatus status;
}
