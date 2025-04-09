package www.library.net.exception;

import lombok.Data;
@Data
public class MyException extends Exception{

    private Integer code;

    public MyException( Integer code,String message) {
        super(message);
        this.code = code;
    }
}
