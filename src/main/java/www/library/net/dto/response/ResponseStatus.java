package www.library.net.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseStatus {
    private Integer code;
    private String msj;
    private static Integer SUCCESS_CODE = 1;
    private static String MESSAGE_CODE = "SUCCESS";

    public static ResponseStatus getMessage() {

        return new ResponseStatus(SUCCESS_CODE, MESSAGE_CODE);
    }
}
