package Exceptions;

import java.io.IOException;

public class WrongInputException extends IOException {
    public WrongInputException (String message) {
        super(message);
    }

}
